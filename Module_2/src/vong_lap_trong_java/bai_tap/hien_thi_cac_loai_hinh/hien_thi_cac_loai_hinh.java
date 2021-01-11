package vong_lap_trong_java.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select;
        do {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            select = input.nextInt();
        }while (select<1 || select>4);
        switch (select){
            case 1:
                hinh1();
                break;
            case 2:
                hinh2();
                break;
            case 3:
                hinh3();
                break;
            case 4:
                System.out.println("Exit");
                break;
        }
    }

    public static void hinh1(){
        for (int i=0; i<3; i++){
            for (int j=0; j<7; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void hinh2(){
        for (int i=5; i>=0; i--){
            for (int j=0; j<i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=1; i<6; i++){
            for (int j=0; j<i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i=5; i>0; i--){
            for (int j=1; j<i; j++){
                System.out.print("  ");
            }
            for (int j=i-1; j<5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i=5; i>0; i--){
            for (int j=i; j<5; j++){
                System.out.print("  ");
            }
            for (int j=0; j<i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void hinh3(){
        int count=0;
        for(int i=5; i>=0; i--){
            for (int j=0; j<i; j++){
                System.out.print("  ");
            }
            for (int j=i; j<=5+count; j++){
                System.out.print("* ");
            }
            System.out.println();
            count+=1;
        }
    }
}
