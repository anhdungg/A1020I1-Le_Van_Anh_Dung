package CaseStudy.manage;

import CaseStudy.controllers.ReadWriteFile;
import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Villa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ManageService {
    final static ReadWriteFile readWriteFile = new ReadWriteFile();
    final String CHECK_ID = "^(SV)(RO|VL|HO)[-]\\d{4}$";
    final String DOUBLE = "^[1-9]*[0-9]*[.]?[0-9]+$";
    final String INTEGER = "^[1-9][0-9]*$";
    final String UPPER_FIRST = "^[A-Z|1-5][\\sa-z]*$";
    final String ACCOMPANIED_SERVICE = "^(Massage|Karaoke|Food|Drink|Car)$";

    public void addNew(Scanner input, String typeService){
        input.nextLine();
        String id = inputData(input, "id");
        String nameService = inputData(input, "nameService");
        String areaUse = inputData(input, "areaUse");
        String rentalCosts = inputData(input, "rentalCosts");
        String maxPeople = inputData(input, "maxPeople");
        String typeRental = inputData(input, "typeRental");
        switch (typeService){
            case "house":
            case "villa":
                String rank = inputData(input, "rank");
                System.out.print("Mô tả tiện nghi khác: ");
                String description = input.nextLine();
                String numberOfFloors = inputData(input, "numberOfFloors");
                if(typeService.equals("villa")) {
                    String areaPool = inputData(input, "areaPool");
                    System.out.println(readWriteFile.writeFile("villa", id+","+nameService+","+areaUse+","+rentalCosts+","+maxPeople+","+typeRental
                            +","+rank+","+description+","+areaPool+","+numberOfFloors+","+inputAccompaniedService(input)));
                    break;
                }
                System.out.println(readWriteFile.writeFile("house", id+","+nameService+","+areaUse+","+rentalCosts+","+maxPeople+","+typeRental
                        +","+rank+","+description+","+numberOfFloors+","+inputAccompaniedService(input)));
                break;
            case "room":
                System.out.print("Dịch vụ miễn phí đi kèm: ");
                String freeService = input.nextLine();
                String unit="0";
                String money="0.0";
                if (!freeService.equals("No")){
                    unit = inputData(input, "unit");
                    money = inputData(input, "money");
                }
                System.out.println(readWriteFile.writeFile("room", id+","+nameService+","+areaUse+","+rentalCosts+","+
                        maxPeople+","+typeRental +","+freeService+","+unit+","+money+","+inputAccompaniedService(input)));
                break;
        }
    }

    private String inputAccompaniedService(Scanner input){
        String unit="0";
        String money = "0.0";
        String accompaniedService = inputData(input, "accompaniedService");
        if(!accompaniedService.equals("No")){
            unit = inputData(input, "unit");
            money = inputData(input, "money");
        }
        return accompaniedService + "," + unit+","+money;
    }

    private String inputData(Scanner input, String type){
        String data;
        String regex = "";
        boolean check = false;
        do {
            switch (type) {
                case "id":
                    System.out.print("Id: ");
                    regex = CHECK_ID;
                    break;
                case "nameService":
                    System.out.print("Tên dịch vụ: ");
                    regex = UPPER_FIRST;
                    break;
                case "areaUse":
                    System.out.print("Diện tích sử dụng: ");
                    regex = DOUBLE;
                    break;
                case "areaPool":
                    System.out.print("Diện tích hồ bơi: ");
                    regex = DOUBLE;
                    break;
                case "rentalCosts":
                    System.out.print("Chi phí thuê: ");
                    regex = DOUBLE;
                    break;
                case "maxPeople":
                    System.out.print("Số người tối đa: ");
                    regex = INTEGER;
                    break;
                case "typeRental":
                    System.out.print("Kiểu thuê: ");
                    regex = UPPER_FIRST;
                    break;
                case "rank":
                    System.out.print("Tiêu chuẩn: ");
                    regex = UPPER_FIRST;
                    break;
                case "numberOfFloors":
                    System.out.print("Số tầng: ");
                    regex = INTEGER;
                    break;
                case "accompaniedService":
                    System.out.print("Dịch vụ đi kèm: ");
                    regex = ACCOMPANIED_SERVICE;
                    break;
                case "unit":
                    System.out.print("Số luọng: ");
                    regex = INTEGER;
                    break;
                case "money":
                    System.out.print("Đơn giá: ");
                    regex = DOUBLE;
                    break;
            }
            data = input.nextLine();
            if(data.matches(regex)){
                switch (type){
                    case "areaUse":
                    case "areaPool":
                        double area = Double.parseDouble(data);
                        check = area < 30;
                        break;
                    case "maxPeople":
                        int max = Integer.parseInt(data);
                        check = max > 20;
                        break;
                    default:
                        check = false;
                }
                if(check){
                    System.out.println("Nhập sai hãy nhập lại.");
                }
            }else {
                System.out.println("Nhập sai hãy nhập lại.");
            }
        }while (!data.matches(regex) || check);
        return data;
    }

    public ArrayList getListService(String data, String typeService){
        String[] dataSave;
        StringBuilder output = new StringBuilder();
        ArrayList list;
        int count=0;
        switch (typeService){
            case "villa":
                dataSave = new String[13];
                list = new ArrayList<Villa>();
                data = data.substring(ReadWriteFile.getHeaderVilla().length()+2);
                break;
            case "house":
                dataSave = new String[12];
                list = new ArrayList<House>();
                data = data.substring(ReadWriteFile.getHeaderHouse().length()+2);
                break;
            default:
                dataSave = new String[12];
                list = new ArrayList<Room>();
                data = data.substring(ReadWriteFile.getHeaderRoom().length()+2);
        }
        for (int i=0; i<data.length(); i++){
            if(data.charAt(i) == ','){
                dataSave[count] = output.toString();
                count++;
                output = new StringBuilder();
                continue;
            }else if((int)data.charAt(i) == 10){
                dataSave[count] = output.toString();
                switch (typeService){
                    case "villa":
                        try {
                            list.add(new Villa(dataSave[0], dataSave[1], Double.parseDouble(dataSave[2]), Double.parseDouble(dataSave[3]),
                                    Integer.parseInt(dataSave[4]), dataSave[5], dataSave[6], dataSave[7], Double.parseDouble(dataSave[8]),
                                    Integer.parseInt(dataSave[9]), dataSave[10], Integer.parseInt(dataSave[11]), Double.parseDouble(dataSave[12])));
                        }catch (NullPointerException e){
                            return null;
                        }
                        break;
                    case "house":
                        try {
                            list.add(new House(dataSave[0], dataSave[1], Double.parseDouble(dataSave[2]), Double.parseDouble(dataSave[3]),
                                    Integer.parseInt(dataSave[4]), dataSave[5], dataSave[6], dataSave[7], Integer.parseInt(dataSave[8]),
                                    dataSave[9], Integer.parseInt(dataSave[10]), Double.parseDouble(dataSave[11])));
                        }catch (NullPointerException e){
                            return null;
                        }
                        break;
                    case "room":
                        try {
                            list.add(new Room(dataSave[0], dataSave[1], Double.parseDouble(dataSave[2]), Double.parseDouble(dataSave[3]),
                                    Integer.parseInt(dataSave[4]), dataSave[5], dataSave[6], Integer.parseInt(dataSave[7]),
                                    Double.parseDouble(dataSave[8]), dataSave[9], Integer.parseInt(dataSave[10]),
                                    Double.parseDouble(dataSave[11])));
                        }catch (NullPointerException e){
                            return null;
                        }
                        break;
                }
                count=0;
                output = new StringBuilder();
                continue;
            }else if ((int)data.charAt(i) == 13){
                continue;
            }
            output.append(data.charAt(i));
        }
        return list;
    }

    public String showServices(String typeService){
        String dataRead = readWriteFile.readFile(typeService);
        if (dataRead.equals("File cannot be read")){
            return dataRead;
        }
        switch (typeService){
            case "villa":
                if(dataRead.length()>=ReadWriteFile.getHeaderVilla().length()+2) {
                    return this.showService(dataRead, "villa");
                }else {
                    return "Villa: No data";
                }
            case "house":
                if(dataRead.length()>ReadWriteFile.getHeaderHouse().length()+2){
                    return this.showService(dataRead, "house");
                }else {
                    return "House: No Data";
                }
            default:
                if(dataRead.length()>=ReadWriteFile.getHeaderRoom().length()+2){
                    return this.showService(dataRead, "room");
                }else {
                    return "Room: No Data";
                }
        }
    }

    private String showService(String data, String typeService){
        StringBuilder output = new StringBuilder();
        ArrayList list = this.getListService(data, typeService);
        if(list == null){
            return "Check your code or header file!!!";
        }
        for (int i=0; i<list.size(); i++){
            output.append(i+1).append(". ");
            if(list.get(i) instanceof Villa){
                Villa villa = (Villa)list.get(i);
                output.append(villa.showInfor());
            }else if(list.get(i) instanceof House){
                House house = (House)list.get(i);
                output.append(house.showInfor());
            }else {
                Room room = (Room)list.get(i);
                output.append(room.showInfor());
            }
            if(i<list.size()-1){
                output.append("\n");
            }
        }
        switch (typeService){
            case "villa":
                output.insert(0, "Villa: " + list.size() + " available \n");
                break;
            case "house":
                output.insert(0, "House: " + list.size() + " available \n");
                break;
            case "room":
                output.insert(0, "Room: " + list.size() + " available \n");
                break;
        }
        return output.toString();
    }

    public String showServiceNotDuplicate(String typeService){
        String dataRead = readWriteFile.readFile(typeService);
        StringBuilder output = new StringBuilder();
        ArrayList list = null;
        TreeSet<String> set = new TreeSet<>();
        if (dataRead.equals("File cannot be read")){
            return dataRead;
        }
        switch (typeService){
            case "villa":
                if(dataRead.length()>=ReadWriteFile.getHeaderVilla().length()+2) {
                    list = getListService(dataRead, typeService);
                    output.append("Villa: ");
                }else {
                    return "Villa: No data";
                }
                break;
            case "house":
                if(dataRead.length()>ReadWriteFile.getHeaderHouse().length()+2){
                    list = getListService(dataRead, typeService);
                    output.append("House: ");
                }else {
                    return "House: No Data";
                }
                break;
            case "room":
                if(dataRead.length()>=ReadWriteFile.getHeaderRoom().length()+2){
                    list = getListService(dataRead, typeService);
                    output.append("Room: ");
                }else {
                    return "Room: No Data";
                }
                break;
        }
        if(list == null){
            return "Check your code or header file!!!";
        }

        for (Object object : list){
            if (object instanceof Villa){
                Villa villa = (Villa) object;
                set.add(villa.getNameService());
            } else if (object instanceof House){
                House house = (House) object;
                set.add(house.getNameService());
            } else {
                Room room = (Room) object;
                set.add(room.getNameService());
            }
        }
        int count=1;
        for (String str : set){
            output.append(count).append(". ").append(str).append("\n");
            count++;
        }
        output = new StringBuilder(output.insert(output.indexOf(":")+2, (count-1) + " available\n"));
        return output.toString().substring(0, output.length()-2);
    }

//    public static void main(String[] args) {
//        ManageService manage = new ManageService();
//        System.out.println(manage.showServiceNotDuplicate("villa"));
//    }
//    private String showService(String data, String typeService){
//        String[] header = new String[]{"Id: ", "Area used: ", "Rental costs: ", "Maximum people: ", "Rent type: "};
//        String[] headerVilla = new String[]{"Standard room: ", "Description of other amenities: ", "Pool area: ",
//                "Number of floors: ", "Accompanied service: ", "Unit: ", "Money: "};
//        String[] headerHouse = new String[]{"Standard room: ", "Description of other amenities: ", "Number of floors: ",
//                "Accompanied service: ", "Unit: ", "Money: "};
//        String[] headerRoom = new String[]{"Free service included: ", "Unit: ", "Money: ", "Accompanied service: ", "Unit: ",
//                "Money: "};
//        StringBuilder dataReturn = new StringBuilder();
//        int count=0;
//        switch (typeService){
//            case "villa":
//                data = data.substring(ReadWriteFile.getHeaderVilla().length()+2, data.length()-2);
//                break;
//            case "house":
//                data = data.substring(ReadWriteFile.getHeaderHouse().length()+2, data.length()-2);
//                break;
//            case "room":
//                data = data.substring(ReadWriteFile.getHeaderRoom().length()+2, data.length()-2);
//                break;
//        }
//        for (int i=0; i<data.length(); i++){
//            if(count<header.length){
//                if(i==0){
//                    dataReturn.append(header[count]);
//                    count++;
//                }else {
//                    if(data.charAt(i)==','){
//                        dataReturn.append(", ").append(header[count]);
//                        count++;
//                        continue;
//                    }
//                }
//            }else {
//                if (data.charAt(i) == ','){
//                    dataReturn.append(", ");
//                    switch (typeService){
//                        case "villa":
//                            dataReturn.append(headerVilla[count-header.length]);
//                            break;
//                        case "house":
//                            dataReturn.append(headerHouse[count-header.length]);
//                            break;
//                        case "room":
//                            dataReturn.append(headerRoom[count-header.length]);
//                            break;
//                    }
//                    count++;
//                    continue;
//                }
//                if((int)data.charAt(i) == 10){
//                    count=0;
//                    dataReturn.append(data.charAt(i)).append(header[count]);
//                    count++;
//                    continue;
//                }
//            }
//            dataReturn.append(data.charAt(i));
//        }
//        return dataReturn.toString();
//    }

//    private ArrayList<ArrayList<String>> handlingString(String data){
//        ArrayList<ArrayList<String>> list = new ArrayList<>();
//        boolean statusRead = false;
//        StringBuilder copyData = new StringBuilder();
//        for (int i = 0; i < data.length(); i++) {
//            if(statusRead){
//                if((int)data.charAt(i) == 10){
//                    list.add(this.splitString(copyData.toString()));
//                    copyData = new StringBuilder();
//                    continue;
//                }
//                copyData.append(data.charAt(i));
//            }
//            if((int)data.charAt(i) == 10 && !statusRead){
//                statusRead = true;
//            }
//        }
//        return list;
//    }
//
//    private String handlingData(ArrayList<ArrayList<String>> list, String typeService){
//        String[] header = new String[]{"Id: ", "Area used: ", "Rental costs: ", "Maximum people: ", "Rent type: "};
//        String[] headerVilla = new String[]{"Standard room: ", "Description of other amenities: ", "Pool area: ",
//                "Number of floors: ", "Accompanied service: ", "Unit: ", "Money: "};
//        String[] headerHouse = new String[]{"Standard room: ", "Description of other amenities: ", "Number of floors: ",
//                "Accompanied service: ", "Unit: ", "Money: "};
//        String[] headerRoom = new String[]{"Free service included: ", "Unit: ", "Money: ", "Accompanied service: ", "Unit: ",
//                "Money: "};
//        StringBuilder dataReturn = new StringBuilder(typeService + ": \n");
//        for (ArrayList<String> list1 : list) {
//            for (int j = 0; j < list1.size(); j++) {
//                if (j < header.length) {
//                    dataReturn.append(header[j]);
//                } else {
//                    switch (typeService) {
//                        case "villa":
//                            dataReturn.append(headerVilla[j - header.length]);
//                            break;
//                        case "house":
//                            dataReturn.append(headerHouse[j - header.length]);
//                            break;
//                        case "room":
//                            dataReturn.append(headerRoom[j - header.length]);
//                            break;
//                    }
//                }
//                dataReturn.append(list1.get(j));
//                if (j < list1.size() - 1) {
//                    dataReturn.append(", ");
//                }
//            }
//            dataReturn.append("\n");
//        }
//        return dataReturn.toString();
//    }
//    private ArrayList<String> splitString(String value){
//        ArrayList<String> list = new ArrayList<>();
//        StringBuilder data = new StringBuilder();
//        for (int i=0; i<value.length(); i++){
//            if(value.charAt(i) == ','){
//                list.add(data.toString());
//                data = new StringBuilder();
//                continue;
//            }
//            data.append(value.charAt(i));
//        }
//        list.add(data.toString());
//        return list;
//    }
}
