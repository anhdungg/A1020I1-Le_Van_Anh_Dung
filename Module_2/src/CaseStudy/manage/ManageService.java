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
        ArrayList list = new ArrayList();
        int count=0;
        if ("villa".equals(typeService)) {
            dataSave = new String[13];
        } else {
            dataSave = new String[12];
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
                if(dataRead.length()>1) {
                    return this.showService(dataRead, "villa");
                }else {
                    return "Villa: No data";
                }
            case "house":
                if(dataRead.length()>1){
                    return this.showService(dataRead, "house");
                }else {
                    return "House: No Data";
                }
            default:
                if(dataRead.length()>1){
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
                if(dataRead.length()>1) {
                    list = getListService(dataRead, typeService);
                    output.append("Villa: ");
                }else {
                    return "Villa: No data";
                }
                break;
            case "house":
                if(dataRead.length()>1){
                    list = getListService(dataRead, typeService);
                    output.append("House: ");
                }else {
                    return "House: No Data";
                }
                break;
            case "room":
                if(dataRead.length()>1){
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
}