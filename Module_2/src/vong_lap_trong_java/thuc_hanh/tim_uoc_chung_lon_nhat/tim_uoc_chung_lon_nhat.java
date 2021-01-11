package vong_lap_trong_java.thuc_hanh.tim_uoc_chung_lon_nhat;

import java.util.Scanner;

public class tim_uoc_chung_lon_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int uocChung=0;
        System.out.print("Nhập a: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.print("Nhập b: ");
        int b = input.nextInt();
        for (int i=1; i<Math.max(a, b); i++){
            if(b%i==0 && a%i==0){
                uocChung = i;
            }
        }
        System.out.println("Ước chung lơn nhất của " + a + " và " + b + " là: " + uocChung);
    }
}
