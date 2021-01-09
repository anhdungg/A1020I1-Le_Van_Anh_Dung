package introduction_to_java.thuc_hanh.tinh_so_ngay_trong_thang;

import java.util.Scanner;

public class tinh_so_ngay_trong_thang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month;
        do {
            System.out.print("Bạn muốn xem số ngày của tháng nào?: ");
            month = input.nextInt();
            if (month<1 || month>12){
                System.out.println("Lỗi");
            }
        }while (month<1 || month>12);
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Tháng " + month + " có 30 ngày");
        }
    }
}
