package CaseStudy.controllers;

import CaseStudy.manage.ManageFilingCabinets;

import java.util.Scanner;

public class ControllerFilingCabinets {
    final private ManageFilingCabinets manage = new ManageFilingCabinets();

    public void mainMenu(Scanner input){
        String select;
        do {
            System.out.print("1. Tìm theo tên\n"+
                    "2. Tìm theo năm sinh\n"+
                    "3. Tìm theo địa chỉ\n"+
                    "4. Thoát\n"+
                    "Chọn menu: ");
            select = input.nextLine();
            switch (select){
                case "1":
                    System.out.println(fineEmployee(input, "name") + "\n");
                    break;
                case "2":
                    System.out.println(fineEmployee(input, "yearOld") + "\n");
                    break;
                case "3":
                    System.out.println(fineEmployee(input, "address") + "\n");
                case "4":
                    break;
                default:
                    System.out.println("Nhập sai xin nhập lại.\n");
            }
        }while (!select.equals("4"));
    }

    private String fineEmployee(Scanner input, String type){
        switch (type){
            case "name":
                System.out.print("Nhập tên: ");
                String name = input.nextLine();
                return manage.findFileEmployee("name", name);
            case "yearOld":
                System.out.print("Nhập tuổi: ");
                int yearOld;
                try {
                    yearOld = input.nextInt();
                    input.nextLine();
                    return manage.findFileEmployee("yearOld", Integer.toString(yearOld));
                }catch (Exception e){
                    return "Không tìm thấy hồ sơ nhân viên.";
                }
            default:
                System.out.print("Nhập địa chỉ: ");
                String address = input.nextLine();
                return manage.findFileEmployee("address", address);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerFilingCabinets controller = new ControllerFilingCabinets();
        controller.mainMenu(input);
    }

}
