package introduction_to_java.thuc_hanh.su_dung_toan_tu;

import java.util.Scanner;

public class dien_tich_hinh_chu_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        float chieuDai = input.nextFloat();
        input.nextLine();
        System.out.print("Nhập chiều rộng: ");
        float chieuRong = input.nextFloat();
        System.out.println("Diện tích hình chữ nhật: " + (chieuDai*chieuRong));
    }
}
