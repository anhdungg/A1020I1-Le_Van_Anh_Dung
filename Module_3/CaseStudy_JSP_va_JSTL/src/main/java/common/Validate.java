package common;

import java.util.Date;

public class Validate {
    private static String date = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static String idCustomer(String input){
        if (input.matches("^(KH-)[\\d]{4}$")){
            return null;
        }else {
            return "Ma khach hang phai co dinh dang KH-XXXX (X la so tu 0-9)";
        }
    }

    public static String idTypeCustomer(String input){
        if (input.matches("^[\\d]+$")){
            return null;
        }else {
            return "Sai loai khach hang";
        }
    }

    public static String dateOfBirth(String input){
        if (input.equals("")){
            return "Ngay thang nam khong hop le(dd/mm/yyyy)";
        }
        Date now = new Date();
        String[] dateSplit = input.split("-");
        input = dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0];
        if ((now.getYear()+1900) - Integer.parseInt(dateSplit[0]) < 18){
            return "Phai lon hon 18 tuoi";
        }
        if (input.matches(date)){
            return null;
        }else {
            return "Ngay thang nam khong hop le(dd/mm/yyyy)";
        }
    }

    public static String CMND(String input){
        if (input.matches("^([\\d]{9}|[\\d]{10})$")){
            return null;
        }else {
            return "So CMND phai dung dinh dang XXXXXXXXX hoac XXXXXXXXXXXX (X la so 0-9)";
        }
    }

    public static String phoneNumber(String input){
        if (input.matches("^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$")){
            return null;
        }else {
            return "So dien thoai phai dung dinh dang 090xxxxxxx hoac 091xxxxxxx hoac (84)+90xxxxxxx hoac (84)+91xxxxxxx";
        }
    }

    public static String email(String input){
        if (input.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")){
            return null;
        }else {
            return "Khong dung dinh dang email";
        }
    }

    public static String dayMonthYear(String input){
        if (input.equals("")){
            return "Ngay thang nam khong hop le(dd/mm/yyyy)";
        }
        String dateSplit[] = input.split("-");
        input = dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0];
        if (input.matches(date)){
            return null;
        }else {
            return "Ngay thang nam khong hop le(dd/mm/yyyy)";
        }
    }

    public static String validateDouble(String input){
        if (input.matches("^[\\d]+[.]?[\\d]*$")){
            return null;
        }else {
            return "Phai la so duong";
        }
    }

    public static String validateInteger(String input){
        if (input.matches("^[\\d]+$")){
            return null;
        }else {
            return "Phai la so nguyen duong";
        }
    }

    public static String idService(String input){
        if (input.matches("^(DV-)[\\d]{4}$")){
            return null;
        }else {
            return "Ma khach hang phai co dinh dang DV-XXXX (X la so tu 0-9)";
        }
    }

    public static String validateNull(String input){
        if (input == null || input.equals("")){
            return "Khong de trong cho nay";
        } else {
            return null;
        }
    }

    public static String pass(String input){
        if (input.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")){
            return null;
        }else {
            return "Mat khau chua ki tu so va viet hoa ki tu dau tien";
        }
    }
}
