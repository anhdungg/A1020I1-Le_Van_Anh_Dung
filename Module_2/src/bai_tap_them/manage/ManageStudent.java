package bai_tap_them.manage;

import java.util.Scanner;

public class ManageStudent {
    public void addNewStudent(Scanner input){
//        String name =
    }

    private String checkInput(Scanner input, String type){
        String checkName = "^[A-Z][a-z]*([\\s][A-Z][a-z]*)*$";
        String checkGender = "^(Male|Female|Unknow)$";
        String checkDayOfBirth = "^[0-3]\\d[/][0-1][0-9][/][0-9]{4}$";
        String checkClass = "[CAP][0-9]{4}[GHIKLM]";
        String regex = "";
        switch (type){
            case "name":
                System.out.print("Name: ");
                regex = checkName;
                break;
            case "gender":
                System.out.print("Gender: ");
                regex = checkGender;
            case "dayOfBirth":
                System.out.print("Gender: ");
                regex = checkDayOfBirth;
            case "class":
                System.out.print("Gender: ");
                regex = checkClass;
        }
        String data = input.nextLine();
        if (data.matches(regex)){
            return data;
        }else {
            return "error";
        }
    }
}
