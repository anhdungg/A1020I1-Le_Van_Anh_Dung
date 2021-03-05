package CaseStudy.controllers;

import java.util.Scanner;

public class ControllerCustomer {
    final static ReadWriteFile readWriteFile = new ReadWriteFile();
    public void addNewCustomer(Scanner input){
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Day of birth: ");
        String dayOfBirth = input.nextLine();
        System.out.print("Gender: ");
        String gender = input.nextLine();
        System.out.print("Id card: ");
        String idCard = input.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Type customer: ");
        String typeCustomer = input.nextLine();
        System.out.print("Address: ");
        String address = input.nextLine();
        String data = name+","+dayOfBirth+","+gender+","+idCard+","+phoneNumber+","+email+","+typeCustomer+","+address;
        readWriteFile.writeFile("customer", data);
    }

    public String showInformationCustomer(){
        String readFile = 
    }
}
