package common;

public class Validate {
    private static String date = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static String id(String input){
        if (input.matches("^[\\dA-Z]{3}(-[\\dA-Z]{2}){2}$")){
            return null;
        }else {
            return "Ma khach hang phai co dinh dang KH-XXXX (X la so tu 0-9)";
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

    public static String validateNull(String input){
        if (input == null || input.equals("")){
            return "Khong de trong cho nay";
        } else {
            return null;
        }
    }
}
