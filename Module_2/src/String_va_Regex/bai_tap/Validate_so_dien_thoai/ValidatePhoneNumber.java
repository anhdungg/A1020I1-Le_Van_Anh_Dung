package String_va_Regex.bai_tap.Validate_so_dien_thoai;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String check = "(\\(84\\)-)\\([0][\\d]{9}\\)";
        System.out.print("Nhập số điện thoại: ");
        String str = input.nextLine();
        if (str.matches(check)){
            System.out.println("Số điện thoại hợp lệ.");
        }else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
    }
}
