package CaseStudy.controllers;

import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Services;
import CaseStudy.models.Villa;

import java.util.Scanner;

public class Controllers {

    ReadWriteFile readWriteFile = new ReadWriteFile();
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
        System.out.print("Id: ");
        String id = input.nextLine();
        System.out.print("Diện tích sử dụng: ");
        double areaUse = input.nextDouble();
        input.nextLine();
        System.out.print("Chi phí thuê: ");
        int rentalCosts = input.nextInt();
        input.nextLine();
        System.out.print("Số người tối đa: ");
        int numberMax = input.nextInt();
        input.nextLine();
        System.out.print("Kiểu thuê(năm, tháng, ngày giờ): ");
        String typeRental = input.nextLine();
        switch (typeService){
            case "house":
            case "villa":
                System.out.print("Tiêu chuẩn phòng: ");
                String rank = input.nextLine();
                System.out.print("Mô tả tiện nghi khác: ");
                String description = input.nextLine();
                System.out.print("Số tầng: ");
                int numberOfFloors = input.nextInt();
                input.nextLine();
                if(typeService.equals("villa")) {
                    System.out.print("Diện tích hồ bơi: ");
                    double areaPool = input.nextDouble();
                    Villa villa = new Villa(id, areaUse, rentalCosts, numberMax, typeRental, rank, description, areaPool, numberOfFloors);
                    readWriteFile.writeFile("villa", villa.writeFile());
//                    System.out.println(villa.showInfor());
                    break;
                }
                House house = new House(id, areaUse, rentalCosts, numberMax, typeRental, rank, description, numberOfFloors);
                System.out.println(house.showInfor());
                break;
            case "room":
                System.out.print("Dịch vụ miễn phí đi kèm: ");
                String freeService = input.nextLine();
                if (!freeService.equals("Không")){
                    System.out.print("Số lượng: ");
                    int unit = input.nextInt();
                    input.nextLine();
                    System.out.print("Đơn giá: ");
                    double money = input.nextDouble();
                    Room room = new Room(id, areaUse, rentalCosts, numberMax, typeRental, freeService, money, unit);
                    System.out.println(room.showInfor());
                }
        }
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
                case 7:
                    return true;
                case 8:
                    return false;
                default:
                    System.out.println("Nhập sai, xin hãy nhập lại.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controllers main = new Controllers();
        main.displayMainMenu(input);
    }

}
