package bai_tap_them.manage;

import bai_tap_them.controller.FileStudent;
import bai_tap_them.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudent {
    private final FileStudent fileStudent = new FileStudent();

    public String addNewStudent(Scanner input){
        String id = this.checkInput(input, "id");
//        while (id.equals("error")){
//            System.out.println("Mã sinh viên phải là số nguyên có độ dài 5 kí tụ");
//            id = this.checkInput(input, "id");
//        }
        String name = this.checkInput(input, "name");
//        while (name.equals("error")){
//            System.out.println("Tên học sinh phải in hoa ký tự đầu tiên trong mỗi từ");
//            name = this.checkInput(input, "name");
//        }
        String gender = this.checkInput(input, "gender");
//        while (gender.equals("error")){
//            System.out.println("Giới tính phải là Male, Female, Unknow");
//            gender = this.checkInput(input, "gender");
//        }
        String dayOfBirth = this.checkInput(input, "dayOfBirth");
//        while (dayOfBirth.equals("error")){
//            System.out.println("Năm sinh phải đúng định dạng dd/mm/yyyy");
//            dayOfBirth = this.checkInput(input, "dayOfBirth");
//        }
        String nameClass = this.checkInput(input, "class");
//        while (nameClass.equals("error")){
//            System.out.println("Tên class phải bắt đầu bằng chữ hoa A hoặc C hoặc P, theo sau là 4 kí tự và kết thúc " +
//                    "bằng những kí tự hoa sau: G, H, I, K, L, M");
//            nameClass = this.checkInput(input, "class");
//        }
        return fileStudent.writeFile(id+","+name+","+gender+","+dayOfBirth+","+nameClass, true);
    }

    private String checkInput(Scanner input, String type){
        String checkId = "[\\d]{5}";
        String checkName = "^[A-Z][a-z]*([\\s][A-Z][a-z]*)*$";
        String checkGender = "^(Male|Female|Unknow)$";
        String checkDayOfBirth = "^[0-3]\\d[/][0-1][0-9][/][0-9]{4}$";
        String checkClass = "[CAP][0-9]{4}[GHIKLM]";
        String regex;
        while (true) {
            switch (type) {
                case "id":
                    System.out.print("Id: ");
                    regex = checkId;
                    break;
                case "name":
                    System.out.print("Name: ");
                    regex = checkName;
                    break;
                case "gender":
                    System.out.print("Gender: ");
                    regex = checkGender;
                    break;
                case "dayOfBirth":
                    System.out.print("Day of birth: ");
                    regex = checkDayOfBirth;
                    break;
                case "class":
                    System.out.print("Class: ");
                    regex = checkClass;
                    break;
                default:
                    return "error";
            }
            String data = input.nextLine();
            if (data.matches(regex)) {
                if (type.equals("id")){
                    if (this.findId(data, this.getListStudent(fileStudent.readFile())) != -1){
                        System.out.println("Mã học sinh đã tồn tại.");
                        continue;
                    }
                }
                return data;
            } else {
                switch (type){
                    case "id":
                        System.out.println("Mã sinh viên phải là số nguyên có độ dài 5 kí tụ");
                        break;
                    case "name":
                        System.out.println("Tên học sinh phải in hoa ký tự đầu tiên trong mỗi từ");
                        break;
                    case "gender":
                        System.out.println("Giới tính phải là Male, Female, Unknow");
                        break;
                    case "dayOfBirth":
                        System.out.println("Năm sinh phải đúng định dạng dd/mm/yyyy");
                        break;
                    case "class":
                        System.out.println("Tên class phải bắt đầu bằng chữ hoa A hoặc C hoặc P, theo sau là 4 kí tự và kết thúc " +
                                "bằng những kí tự hoa sau: G, H, I, K, L, M");
                        break;
                    default:
                        System.out.println("Kiểm tra lại code!!!");

                }
            }
        }
    }

    public String showAllStudent(){
        String dataStudent = fileStudent.readFile();
        ArrayList<Student> list = this.getListStudent(dataStudent);
        if (list.isEmpty()){
            return "Student: no data";
        }
        StringBuilder output = new StringBuilder("Student: " + list.size() + " available\n");
        for (int i=0; i<list.size(); i++){
            output.append(i+1).append(". ").append(list.get(i)).append("\n");
        }
        return output.substring(0, output.length()-1);
    }

    public String editStudent(Scanner input){
        System.out.print("Nhập id: ");
        String id = input.nextLine();
        ArrayList<Student> list = this.getListStudent(fileStudent.readFile());
        int localId = this.findId(id, list);
        if (localId==-1){
            return "Không tìm thấy Id học sinh.";
        }

        list.get(localId).setName(this.checkInput(input, "name"));
        list.get(localId).setGender(this.checkInput(input, "gender"));
        list.get(localId).setDayOfBirth(this.checkInput(input, "dayOfBirth"));
        list.get(localId).setNameClass(this.checkInput(input, "class"));
        StringBuilder output = new StringBuilder();
        for (int i=0; i<list.size(); i++){
            output.append(list.get(i).getDataWriteFile());
            if (i<list.size()-1){
                output.append("\n");
            }
        }
        return fileStudent.writeFile(output.toString(), false);
    }

    private int findId(String id, ArrayList<Student> list){
        if (list.isEmpty()){
            return -1;
        }
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<Student> getListStudent(String dataStudent){
        ArrayList<Student> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        String[] saveData = new String[5];
        int count=0;
        for (int i=0; i<dataStudent.length(); i++){
            if (dataStudent.charAt(i) == ','){
                saveData[count] = str.toString();
                count++;
                str = new StringBuilder();
                continue;
            }else if ((int)dataStudent.charAt(i) == 10){
                saveData[count] = str.toString();
                count=0;
                str = new StringBuilder();
                list.add(new Student(saveData[0], saveData[1], saveData[2], saveData[3], saveData[4]));
                continue;

            }else if ((int)dataStudent.charAt(i) == 13){
                continue;
            }
            str.append(dataStudent.charAt(i));
        }
        return list;
    }

    public static void main(String[] args) {
//        ManageStudent manage = new ManageStudent();
//        Scanner input = new Scanner(System.in);
//        System.out.println(manage.editStudent(input));
    }
}
