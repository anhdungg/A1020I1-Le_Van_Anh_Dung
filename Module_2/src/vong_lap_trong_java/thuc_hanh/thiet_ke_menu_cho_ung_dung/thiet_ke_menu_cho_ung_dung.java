package vong_lap_trong_java.thuc_hanh.thiet_ke_menu_cho_ung_dung;

import java.util.Scanner;

public class thiet_ke_menu_cho_ung_dung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select;
        do {
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            select = input.nextInt();
        }while (select<0 || select>3);
        switch (select){
            case 1:
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
                break;
            case 2:
                for (int i=0; i<6; i++){
                    for (int j=0; j<6; j++){
                        System.out.print("*  ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i=0; i<3; i++){
                    for (int j=0; j<6; j++){
                        System.out.print("*  ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
