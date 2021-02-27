package CaseStudy.controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class Controllers {
    ReadWriteFile readWriteFile = new ReadWriteFile();
    final String CHECK_ID = "^(SV)(RO|VL|HO)[-]\\d{4}$";
    final String DOUBLE = "^[1-9][0-9]*[.]?[0-9]+$";
    final String INTEGER = "^[1-9][0-9]*$";
    final String UPPER_FIRST = "^[A-Z|1-5][\\s]?[a-z]+$";
    final String ACCOMPANIED_SERVICE = "^(Massage|Karaoke|Food|Drink|Car)$";
    public void displayMainMenu(Scanner input) {
        while (true) {
            System.out.println("1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    if(this.addNewServices(input)){
                        break;
                    }else {
                        return;
                    }
                case 2:
                    if(this.showServices(input)){
                       break;
                    }else{
                        return;
                    }
                case 7:
                    return;
                default:
                    System.out.println("Nhập sai, xin hãy nhập lại.");
            }
        }
    }

    private boolean addNewServices(Scanner input){
        while (true) {
            System.out.println("1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to menu\n" +
                    "5. Exit");
            int select = input.nextInt();
            switch (select){
                case 1:
                    addNew(input, "villa");
                    break;
                case 2:
                    addNew(input, "house");
                    break;
                case 3:
                    addNew(input, "room");
                    break;
                case 4:
                    return true;
                case 5:
                    return false;
                default:
                    System.out.println("Nhập sai, xin hãy nhập lại.");
            }
        }
    }

    private void addNew(Scanner input, String typeService){
        input.nextLine();
        String id = inputData(input, "id");
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
                    readWriteFile.writeFile("villa", id+","+areaUse+","+rentalCosts+","+maxPeople+","+typeRental
                            +","+rank+","+description+","+areaPool+","+numberOfFloors+","+inputAccompaniedService(input));
                    break;
                }
                readWriteFile.writeFile("house", id+","+areaUse+","+rentalCosts+","+maxPeople+","+typeRental
                        +","+rank+","+description+","+numberOfFloors+","+inputAccompaniedService(input));
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
                readWriteFile.writeFile("room", id+","+areaUse+","+rentalCosts+","+maxPeople+","+typeRental
                        +","+freeService+","+unit+","+money+","+inputAccompaniedService(input));
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
    private boolean showServices(Scanner input){
        while(true) {
            System.out.println("1. Show all Villa\n" +
                    "2. Show all House\n" +
                    "3. Show all Room\n" +
                    "4. Show All Name Villa Not Duplicate\n" +
                    "5. Show All Name House Not Duplicate\n" +
                    "6. Show All Name Room Not Duplicate\n" +
                    "7. Back to menu\n" +
                    "8. Exit");
            int select = input.nextInt();
            switch (select){
                case 1:
                    System.out.println(showServices("villa"));
                    break;
                case 2:
                    System.out.println(showServices("house"));
                    break;
                case 3:
                    System.out.println(showServices("room"));
                    break;
                case 7:
                    return true;
                case 8:
                    return false;
                default:
                    System.out.println("Nhập sai, xin hãy nhập lại.");
            }
        }
    }

    private String showServices(String typeService){
        StringBuilder dataReturn = new StringBuilder();
        String dataRead;
        switch (typeService){
            case "villa":
                dataRead = readWriteFile.readFile("villa");
                if(dataRead.length()>=ReadWriteFile.getHeaderVilla().length()+2) {
                    ArrayList<ArrayList<String>> list = handlingString(dataRead);
                    dataReturn.append(handlingData(list, "villa"));
                }else dataReturn.append("Villa: No data");
                break;
            case "house":
                dataRead = readWriteFile.readFile("house");
                if(dataRead.length()>ReadWriteFile.getHeaderHouse().length()+2){
                    ArrayList<ArrayList<String>> list = handlingString(dataRead);
                    dataReturn.append(handlingData(list, "house"));
                }else {
                    dataReturn.append("House: No Data");
                }
                break;
            case "room":
                dataRead = readWriteFile.readFile("room");
                if(dataRead.length()>=ReadWriteFile.getHeaderRoom().length()+2){
                    ArrayList<ArrayList<String>> list = handlingString(dataRead);
                    dataReturn.append(handlingData(list, "room"));
                }else {
                    dataReturn.append("Room: No Data");
                }
                break;
            case "customer":
                dataRead = readWriteFile.readFile("customer");
                if(dataRead.length()>=ReadWriteFile.getHeaderCustomer().length()+2){
                    ArrayList<ArrayList<String>> list = handlingString(dataRead);
                    dataReturn.append(handlingData(list, "customer"));
                }else {
                    dataReturn.append("Customer: No Data");
                }
                break;
        }
        return dataReturn.toString();
    }

    private ArrayList<ArrayList<String>> handlingString(String data){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        boolean statusRead = false;
        StringBuilder copyData = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if(statusRead){
                if((int)data.charAt(i) == 10){
                    list.add(this.splitString(copyData.toString()));
                    copyData = new StringBuilder();
                    continue;
                }
                copyData.append(data.charAt(i));
            }
            if((int)data.charAt(i) == 10 && !statusRead){
                statusRead = true;
            }
        }
        return list;
    }
    private String handlingData(ArrayList<ArrayList<String>> list, String typeService){
        String[] header = new String[]{"Id: ", "Area used: ", "Rental costs: ", "Maximum people: ", "Rent type: "};
        String[] headerVilla = new String[]{"Standard room: ", "Description of other amenities: ", "Pool area: ",
                "Number of floors: ", "Accompanied service: ", "Unit: ", "Money: "};
        String[] headerHouse = new String[]{"Standard room: ", "Description of other amenities: ", "Number of floors: ",
                "Accompanied service: ", "Unit: ", "Money: "};
        String[] headerRoom = new String[]{"Free service included: ", "Unit: ", "Money: ", "Accompanied service: ", "Unit: ",
                "Money: "};
        String[] headerCustomer = new String[]{"Name: ", "Day of birth: ", "Gender: ", "Id card: ", "Phone number: ",
                "Email: ", "Type customer: ", "Address: "};
        StringBuilder dataReturn = new StringBuilder(typeService + ": \n");
        for (ArrayList<String> list1 : list) {
            for (int j = 0; j < list1.size(); j++) {
                if (j < header.length) {
                    dataReturn.append(header[j]);
                } else {
                    switch (typeService) {
                        case "villa":
                            dataReturn.append(headerVilla[j - header.length]);
                            break;
                        case "house":
                            dataReturn.append(headerHouse[j - header.length]);
                            break;
                        case "room":
                            dataReturn.append(headerRoom[j - header.length]);
                            break;
                    }
                }
                dataReturn.append(list1.get(j));
                if (j < list1.size() - 1) {
                    dataReturn.append(", ");
                }
            }
            dataReturn.append("\n");
        }
        return dataReturn.toString();
    }
    private ArrayList<String> splitString(String value){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder data = new StringBuilder();
        for (int i=0; i<value.length(); i++){
            if(value.charAt(i) == ','){
                list.add(data.toString());
                data = new StringBuilder();
                continue;
            }
            data.append(value.charAt(i));
        }
        list.add(data.toString());
        return list;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controllers main = new Controllers();
        main.displayMainMenu(input);
    }

}
