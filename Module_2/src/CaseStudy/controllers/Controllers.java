package CaseStudy.controllers;

import CaseStudy.manage.ManageService;
import java.util.Scanner;

public class Controllers {
    final static ManageService manage = new ManageService();
    public void displayMainMenu(Scanner input) {
        while (true) {
            System.out.println("1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            System.out.print("Please select menu: ");
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
            System.out.print("Please select menu: ");
            int select = input.nextInt();
            switch (select){
                case 1:
                    manage.addNew(input, "villa");
                    break;
                case 2:
                    manage.addNew(input, "house");
                    break;
                case 3:
                    manage.addNew(input, "room");
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
            System.out.print("Please select menu: ");
            int select = input.nextInt();
            switch (select){
                case 1:
                    System.out.println("Villa: \n" + manage.showServices("villa") + "\n");
                    break;
                case 2:
                    System.out.println("House: \n" + manage.showServices("house") + "\n");
                    break;
                case 3:
                    System.out.println("Room: \n" + manage.showServices("room") + "\n");
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controllers controllers = new Controllers();
        controllers.displayMainMenu(input);
    }
}
