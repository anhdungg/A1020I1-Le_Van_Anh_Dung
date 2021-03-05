package CaseStudy.manage;

import CaseStudy.controllers.ReadWriteFile;

import java.util.Scanner;

public class ManageCustomer {
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
        String[] nameProperties = {"Name: ", "Day of birth: ", "Gender: ", "Id card: ", "Phone number: ", "Email: ",
                "Type customer: ", "Address: "};
        StringBuilder dataReturn = new StringBuilder();
        int count=0;
        String readFile = readWriteFile.readFile("customer");
        readFile = readFile.substring(readFile.indexOf("Address") + 9, readFile.length()-2);
        for (int i=0; i<readFile.length(); i++){
            if(i==0){
                dataReturn.append(nameProperties[count]);
                count++;
            }else {
                if(readFile.charAt(i)==','){
                    dataReturn.append(", ").append(nameProperties[count]);
                    count++;
                    continue;
                }
                if((int)readFile.charAt(i)==10){
                    count=0;
                    dataReturn.append(readFile.charAt(i)).append(nameProperties[count]);
                    count++;
                    continue;
                }
            }
            dataReturn.append(readFile.charAt(i));
        }
        return dataReturn.toString();
    }
}
