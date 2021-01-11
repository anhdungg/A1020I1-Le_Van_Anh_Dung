package vong_lap_trong_java.thuc_hanh.kiem_tra_so_nguyen_to;

import java.util.Scanner;

public class kiem_tra_so_nguyen_to {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số bạn muốn kiểm tra: ");
        int number = input.nextInt();
        boolean check = true;
        for (int i=2; i<number; i++){
            if(number%i==0){
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Số bạn vừa nhập là số nguyên tố");
        }
        else {
            System.out.println("Sô bạn vừa nhập không phải là số nguyên tố");
        }
    }
}
