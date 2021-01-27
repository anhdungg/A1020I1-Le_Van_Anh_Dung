package CaseStudy.Task_1.controllers;

import java.util.Scanner;

public class Controllers {
    public void displayMainMenu(Scanner input){
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Exit");
        int select = input.nextInt();
    }
}
