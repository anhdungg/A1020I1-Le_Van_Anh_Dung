package bai_tap_them.controller;

import bai_tap_them.manage.ManageStudent;

import java.util.Scanner;

public class ControllerStudent {
    private final ManageStudent manage = new ManageStudent();
    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("1. Add student\n" +
                    "2. Show all student\n" +
                    "3. Edit student\n" +
                    "4. Delete student\n" +
                    "5. Find student\n" +
                    "6. Exit\n" +
                    "Please select menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    System.out.println(manage.addNewStudent(input) + "\n");
                    break;
                case "2":
                    System.out.println(manage.showAllStudent() + "\n");
                    break;
                case "3":
                    System.out.println(manage.editStudent(input) + "\n");
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Error. Please select menu.");

            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerStudent controller = new ControllerStudent();
        controller.displayMainMenu(input);
    }
}
