package vong_lap_trong_java.thuc_hanh.ung_dung_tinh_tien_lai_cho_vay;

import java.util.Scanner;

public class ung_dung_tinh_tien_lai_cho_vay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Số tiền cho vay: ");
        int tien = input.nextInt();
        input.nextLine();
        System.out.print("Tỉ lệ lãi suất theo tháng: ");
        double laiSuat = input.nextDouble();
        input.nextLine();
        System.out.print("Số tháng cho vay");
        int thang = input.nextInt();
        double result = (double) tien * laiSuat/12*thang;
        System.out.println("Số tiền có được khi hết thời hạn cho vay là: " + result);
    }
}
