package introduction_to_java.thuc_hanh.kiem_tra_nam_nhuan;

import java.util.Scanner;

public class kiem_tra_nam_nhuan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bạn muốn kiểm tra năm nào?: ");
        int year = input.nextInt();
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    System.out.println(year + " is a leap year");
                } else {
                    System.out.println(year + " is NOT a leap year");
                }
            } else {
                System.out.println(year + " is a leap year");
            }
        } else {
            System.out.println(year + " is NOT a leap year");
        }
    }
}
