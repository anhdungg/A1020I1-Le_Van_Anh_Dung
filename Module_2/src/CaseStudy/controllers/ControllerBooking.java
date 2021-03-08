package CaseStudy.controllers;

import CaseStudy.manage.ManageBooking;

import java.util.Scanner;

public class ControllerBooking {
    private final static ManageBooking booking = new ManageBooking();
    public static void displayMainMenu(Scanner input){
        int select=0;
        do {
            System.out.print("1. Booking Villa. \n" +
                    "2. Booking House. \n" +
                    "3. Booking Room. \n" +
                    "4. Exit. \n" +
                    "Please select menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    booking.showService("villa");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error. Please select menu");
            }
        }while (select!=4);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        ControllerBooking booking = new ControllerBooking();
        displayMainMenu(input);
    }
}
