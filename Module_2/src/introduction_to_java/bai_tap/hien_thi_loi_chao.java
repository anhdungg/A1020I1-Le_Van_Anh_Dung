package introduction_to_java.bai_tap;

import java.util.Scanner;

public class hien_thi_loi_chao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello: " + name);
    }
}
