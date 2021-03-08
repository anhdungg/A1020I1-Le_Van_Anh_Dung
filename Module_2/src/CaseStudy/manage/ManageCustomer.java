package CaseStudy.manage;

import CaseStudy.controllers.ReadWriteFile;
import CaseStudy.models.Customer;

import java.util.*;

public class ManageCustomer {
    final static ReadWriteFile readWriteFile = new ReadWriteFile();
    public void addNewCustomer(Scanner input){
        String name = this.checkInputData(input, "name");
        while (name.equals("error")){
            System.out.println("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
            name = this.checkInputData(input, "name");
        }
        String dayOfBirth = this.checkInputData(input, "day of birth");
        while (dayOfBirth.equals("error")){
            System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
            dayOfBirth = this.checkInputData(input, "day of birth");
        }
        String gender = this.checkInputData(input, "gender");
        while (gender.equals("error")){
            System.out.println("Giới tính phải là Male, Female, Unknow");
            gender = this.checkInputData(input, "gender");
        }
        String idCard = this.checkInputData(input, "id");
        while (idCard.equals("error")){
            System.out.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            idCard = this.checkInputData(input, "id");
        }
        System.out.print("Phone number: ");
        String phoneNumber = input.nextLine();
        String email = this.checkInputData(input, "email");
        while (email.equals("error")){
            System.out.println("Email phải đúng định dạng abc@abc.abc");
            email = this.checkInputData(input, "email");
        }
        System.out.print("Type customer: ");
        String typeCustomer = input.nextLine();
        System.out.print("Address: ");
        String address = input.nextLine();
        String data = name+","+dayOfBirth+","+gender+","+idCard+","+phoneNumber+","+email+","+typeCustomer+","+address;
        readWriteFile.writeFile("customer", data);
    }

    private String checkInputData(Scanner input, String typeData){
        String checkName = "^[A-Z][a-z]*([\\s][A-Z][a-z]*)*$";
        String checkGender = "^(Male|Female|Unknow)$";
        String checkEmail = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";
        String checkIdCard = "^[0-9]{3}[\\s][0-9]{3}[\\s][0-9]{3}";
        String checkDayOfBirth = "^[0-3]\\d[\\/][0-1][0-9][\\/][0-9]{4}$";
        String regex = "";
        switch (typeData){
            case "name":
                System.out.print("Name: ");
                regex = checkName;
                break;
            case "day of birth":
                System.out.print("Day of birth: ");
                regex = checkDayOfBirth;
                break;
            case "gender":
                System.out.print("Gender: ");
                regex = checkGender;
                break;
            case "id":
                System.out.print("Id card: ");
                regex = checkIdCard;
                break;
            case "email":
                System.out.print("Email: ");
                regex = checkEmail;
                break;
        }
        String data = input.nextLine();
        switch (typeData){
            case "name":
            case "email":
            case "id":
                if(data.matches(regex)){
                    return data;
                }else {
                    return "error";
                }
            case "gender":
                data = data.toLowerCase();
                StringBuilder copyData = new StringBuilder();
                copyData.append(Character.toUpperCase(data.charAt(0)));
                for (int i=1; i<data.length(); i++){
                    copyData.append(data.charAt(i));
                }
                if(copyData.toString().matches(regex)){
                    return copyData.toString();
                }else {
                    return "error";
                }
            case "day of birth":
                Date now = new Date();
                if(data.matches(regex)){
                    String year = data.substring(data.lastIndexOf("/")+1);
                    int yearOfBirth = Integer.parseInt(year);
                    if(yearOfBirth>1900 && ((now.getYear()+1900)-yearOfBirth>18)){
                        return data;
                    }else {
                        return "error";
                    }
                }
        }
        return "error";
    }

//    public String showInformationCustomer(){
//        String[] nameProperties = {"Name: ", "Day of birth: ", "Gender: ", "Id card: ", "Phone number: ", "Email: ",
//                "Type customer: ", "Address: "};
//        StringBuilder dataReturn = new StringBuilder();
//        int count=0;
//        String readFile = readWriteFile.readFile("customer");
//        readFile = readFile.substring(readFile.indexOf("Address") + 9, readFile.length()-2);
//        for (int i=0; i<readFile.length(); i++){
//            if(i==0){
//                dataReturn.append(nameProperties[count]);
//                count++;
//            }else {
//                if(readFile.charAt(i)==','){
//                    dataReturn.append(", ").append(nameProperties[count]);
//                    count++;
//                    continue;
//                }
//                if((int)readFile.charAt(i)==10){
//                    count=0;
//                    dataReturn.append(readFile.charAt(i)).append(nameProperties[count]);
//                    count++;
//                    continue;
//                }
//            }
//            dataReturn.append(readFile.charAt(i));
//        }
//        return dataReturn.toString();
//    }

    public String showInformationCustomer(){
        SortCustomer sort = new SortCustomer();
        String[] properties = new String[8];
        ArrayList<Customer> list = new ArrayList<>();
        String dataFile = readWriteFile.readFile("customer");
        dataFile = dataFile.substring(dataFile.indexOf("Address") + 8);
        int count = 0;
        StringBuilder data = new StringBuilder();
        for (int i=0; i<dataFile.length(); i++){
            if(dataFile.charAt(i) == ','){
                properties[count] = data.toString();
                count++;
                data = new StringBuilder();
                continue;
            }else if((int)dataFile.charAt(i) == 10){
                properties[count] = data.toString();
                list.add(new Customer(properties[0], properties[1], properties[2], properties[3], properties[4], properties[5],
                        properties[6], properties[7]));
                count=0;
                data = new StringBuilder();
                continue;
            }else if ((int)dataFile.charAt(i) == 13){
                continue;
            }
            data.append(dataFile.charAt(i));
        }
        Collections.sort(list, sort);
        data = new StringBuilder();
        for (Customer customer : list){
            data.append(customer.showInfor()).append("\n");
        }
        return data.toString();
    }
}
