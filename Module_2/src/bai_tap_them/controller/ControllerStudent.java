package bai_tap_them.controller;

import bai_tap_them.manage.ManageStudent;

import java.util.Scanner;

public class ControllerStudent {
    private final ManageStudent manage = new ManageStudent();
    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("1. Add student\n" +
                    "2. Edit student\n" +
                    "3. Delete student\n" +
                    "4. Find student\n" +
                    "5. Exit\n" +
                    "Please select menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Error. Please select menu.");

            }
        }
    }
}
