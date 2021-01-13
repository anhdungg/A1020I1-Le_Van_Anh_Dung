package mang_va_phuong_thuc_trong_java.bai_tap.them_phan_tu_vao_mang;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void printArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(", ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        int local=0;
        System.out.print("Mảng trước khi chèn: ");
        printArray(array);
        System.out.println();
        do {
            System.out.print("Nhập vị trí muốn chèn: ");
            local = input.nextInt();
            if(local>array.length-1){
                System.out.println("Vị trí muốn chèn lớn hơn độ dài mảng. Nhập lại");
            }
        }while (local>array.length-1 || local<0);
        System.out.print("Nhập giá trị: ");
        int number = input.nextInt();
        for (int i=array.length-2; i>=local; i--){
            array[i+1] = array[i];
        }
        array[local] = number;
        System.out.println();
        System.out.print("Mảng sau khi chèn: ");
        printArray(array);
    }
}
