package CaseStudy.controllers;

import CaseStudy.manage.ManageBooking;
import CaseStudy.manage.ManageCustomer;
import CaseStudy.manage.ManageEmployee;
import CaseStudy.manage.ManageService;
import java.util.Scanner;

public class Controllers {
    final private ManageService manageService = new ManageService();
    final private ManageCustomer manageCustomer = new ManageCustomer();
    final private ManageBooking manageBooking = new ManageBooking();
    final private ManageEmployee manageEmployee = new ManageEmployee();

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
                case 3:
                    manageCustomer.addNewCustomer(input);
                    break;
                case 4:
                    System.out.println(manageCustomer.showInformationCustomer() + "\n");
                    break;
                case 5:
                    if (this.addNewBooking(input)){
                        break;
                    }else {
                        return;
                    }
                case 6:
                    System.out.println(manageEmployee.showInformationEmployee() + "\n");
                    break;
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
                    manageService.addNew(input, "villa");
                    break;
                case 2:
                    manageService.addNew(input, "house");
                    break;
                case 3:
                    manageService.addNew(input, "room");
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
                    System.out.println(manageService.showServices("villa") + "\n");
                    break;
                case 2:
                    System.out.println(manageService.showServices("house") + "\n");
                    break;
                case 3:
                    System.out.println(manageService.showServices("room") + "\n");
                    break;
                case 4:
                    System.out.println(manageService.showServiceNotDuplicate("villa") + "\n");
                    break;
                case 5:
                    System.out.println(manageService.showServiceNotDuplicate("house") + "\n");
                    break;
                case 6:
                    System.out.println(manageService.showServiceNotDuplicate("room") + "\n");
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

    public boolean addNewBooking(Scanner input){
        int select;
        while(true) {
            System.out.print("1. Booking Villa. \n" +
                    "2. Booking House. \n" +
                    "3. Booking Room. \n" +
                    "4. Back. \n" +
                    "5. Exit. \n" +
                    "Please select menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    manageBooking.selectMenu(input, "villa");
                    break;
                case 2:
                    manageBooking.selectMenu(input, "house");
                    break;
                case 3:
                    manageBooking.selectMenu(input, "room");
                    break;
                case 4:
                    return true;
                case 5:
                    return false;
                default:
                    System.out.println("Error. Please select menu");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controllers controllers = new Controllers();
        controllers.displayMainMenu(input);
    }
}
