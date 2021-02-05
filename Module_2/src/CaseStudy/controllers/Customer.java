package CaseStudy.controllers;

import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Services;
import CaseStudy.models.Villa;

import java.util.Scanner;

public class Customer {
    private String name;
    private String gender;
    private String dayOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services service = null;
    private final ReadWriteFile readWriteFile = new ReadWriteFile();

    public void addNewCustomer(Scanner input){
        System.out.print("Name: ");
        this.name = input.nextLine();
        System.out.print("Day of birth: ");
        this.dayOfBirth = input.nextLine();
        System.out.print("Gender: ");
        this.gender = input.nextLine();
        System.out.print("Id card: ");
        this.idCard = input.nextLine();
        System.out.print("Phone number: ");
        this.phoneNumber = input.nextLine();
        System.out.print("Email: ");
        this.email = input.nextLine();
        System.out.print("Type customer: ");
        this.typeCustomer = input.nextLine();
        System.out.print("Address: ");
        this.address = input.nextLine();
        String data = this.name+","+this.dayOfBirth+","+this.gender+","+this.idCard+","+this.phoneNumber+","+this.email+","+this.typeCustomer
                +","+this.address;
        readWriteFile.writeFile("customer", data);
    }

    public String showInfor(){
        String showService;
        if(service instanceof Villa){
            showService = ((Villa) service).showInfor();
        }else if(service instanceof House){
            showService = ((House) service).showInfor();
        }else {
            showService = ((Room) service).showInfor();
        }
        return "Name: " + this.name + ", Gender: " + this.gender + ", Day of birth: " + this.dayOfBirth
                +", Id card: " + this.idCard + ", Phone number: " + this.phoneNumber
                + ", Type customer: " +  this.typeCustomer + ", Address: " + this.address + "\nService: " + showService;
    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Customer customer = new Customer();
//        customer.addNewCustomer(input);
//    }
}
