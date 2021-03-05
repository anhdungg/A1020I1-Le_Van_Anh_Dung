package CaseStudy.controllers;

import CaseStudy.manage.ManageCustomer;

import java.util.Scanner;

public class ControllerCustomer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManageCustomer manage = new ManageCustomer();
        int select;
        do {
            System.out.println("1. Add new Customer. \n" +
                    "2. Show information Customer. \n" +
                    "3. Exit.");
            System.out.print("Select menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    manage.addNewCustomer(input);
                    break;
                case 2:
                    System.out.println(manage.showInformationCustomer());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Error. Please select menu");
            }
        }while (select!=3);
    }
}
