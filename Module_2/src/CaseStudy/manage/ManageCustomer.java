package CaseStudy.manage;

import CaseStudy.common.ReadWriteFile;
import CaseStudy.models.Customer;

import java.util.*;

public class ManageCustomer {
    final static ReadWriteFile readWriteFile = new ReadWriteFile();
    public void addNewCustomer(Scanner input){
        String name = this.checkInputData(input, "name");
        while (name.equals("error") || name.equals("exit")){
            if (name.equals("exit")){
                return;
            }
            System.out.println("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
            name = this.checkInputData(input, "name");
        }

        String dayOfBirth = this.checkInputData(input, "day of birth");
        while (dayOfBirth.equals("error") || dayOfBirth.equals("exit")){
            if (dayOfBirth.equals("exit")){
                return;
            }
            System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
            dayOfBirth = this.checkInputData(input, "day of birth");
        }

        String gender = this.checkInputData(input, "gender");
        while (gender.equals("error") || gender.equals("exit")){
            if (gender.equals("exit")){
                return;
            }
            System.out.println("Giới tính phải là Male, Female, Unknow");
            gender = this.checkInputData(input, "gender");
        }

        String idCard = this.checkInputData(input, "id");
        while (idCard.equals("error") || idCard.equals("exit")){
            if (idCard.equals("exit")){
                return;
            }
            System.out.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            idCard = this.checkInputData(input, "id");
        }

        System.out.print("Phone number: ");
        String phoneNumber = input.nextLine();
        if (phoneNumber.equals("exit")){
            return;
        }

        String email = this.checkInputData(input, "email");
        while (email.equals("error") || email.equals("exit")){
            if (email.equals("exit")){
                return;
            }
            System.out.println("Email phải đúng định dạng abc@abc.abc");
            email = this.checkInputData(input, "email");
        }

        System.out.print("Type customer: ");
        String typeCustomer = input.nextLine();
        if (typeCustomer.equals("exit")){
            return;
        }

        String address = this.checkInputData(input, "address");
        while (address.equals("error") || address.equals("exit")){
            if (address.equals("exit")){
                return;
            }
            System.out.println("Địa chỉ không chứa kí tự ',' và khoảng trắng sau cùng.");
            address = this.checkInputData(input, "address");
        }
        String data = name+","+dayOfBirth+","+gender+","+idCard+","+phoneNumber+","+email+","+typeCustomer+","+address;
        System.out.println(readWriteFile.writeFile("customer", data));
    }

    private String checkInputData(Scanner input, String typeData){
        String checkName = "^[A-Z][a-z]*([\\s][A-Z][a-z]*)*$";
        String checkGender = "^(Male|Female|Unknow)$";
        String checkEmail = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";
        String checkIdCard = "^[0-9]{3}[\\s][0-9]{3}[\\s][0-9]{3}";
        String checkDayOfBirth = "^[0-3]\\d[/][0-1][0-9][/][0-9]{4}$";
        String checkAddress = "^[\\w]+([ ][\\w]+)*$";
        String regex = "";
        switch (typeData){
            case "name":
                System.out.print("Tên(nhập exit để thoát): ");
                regex = checkName;
                break;
            case "day of birth":
                System.out.print("Ngày tháng năm sinh(nhập exit để thoát): ");
                regex = checkDayOfBirth;
                break;
            case "gender":
                System.out.print("Giới tính(nhập exit để thoát): ");
                regex = checkGender;
                break;
            case "id":
                System.out.print("Số CMND(nhập exit để thoát): ");
                regex = checkIdCard;
                break;
            case "email":
                System.out.print("Email(nhập exit để thoát): ");
                regex = checkEmail;
                break;
            case "address":
                System.out.print("Địa chỉ(nhập exit để thoát): ");
                regex = checkAddress;
                break;
        }
        String data = input.nextLine();
        if (data.equals("exit")){
            return data;
        }
        switch (typeData){
            case "name":
            case "email":
            case "id":
            case "address":
                if(data.matches(regex)){
                    return data;
                }else {
                    return "error";
                }
            case "gender":
                data = data.toLowerCase();
                StringBuilder copyData = new StringBuilder();
                copyData.append(Character.toUpperCase(data.charAt(0))).append(data.substring(1));
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

    public String showInformationCustomer(){
        String[] properties = new String[8];
        ArrayList<Customer> list = new ArrayList<>();
        String dataFile = readWriteFile.readFile("customer");
        if(dataFile.equals("File cannot be read")){
            return dataFile;
        }else if (dataFile.length()<2){
            return "Customer: no data";
        }
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
        list.sort(new SortCustomer());
        data = new StringBuilder();
        for (int i=0; i<list.size(); i++){
            data.append(i+1).append(". ").append(list.get(i).showInfor());
            if(i<list.size()-1){
                data.append("\n");
            }else {
                data.insert(0, "Customer: " + (i+1) + " available\n");
            }
        }
        return data.toString();
    }
}
