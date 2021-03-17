package bai_tap_them.controller;

import java.util.Scanner;

public class ControllerStudy {
    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("1. Add study\n" +
                    "2. Edit study\n" +
                    "3. Delete study\n" +
                    "4. Find student\n" +
                    "5. Exit");
        }
    }
}
