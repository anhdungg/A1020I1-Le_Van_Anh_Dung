package String_va_Regex.bai_tap.Validate_ten_cua_lop_hoc;

import java.util.Scanner;

public class ValidateNameClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String check = "[CAP][0-9]{4}[GHIKLM]";
        System.out.print("Nhập tên lớp học: ");
        String str = input.nextLine();
        if (str.matches(check)){
            System.out.println("Tên lớp hợp lệ.");
        }else {
            System.out.println("Tên lớp không hợp lệ.");
        }
    }
}
