package mang_va_phuong_thuc_trong_java.thuc_hanh.dem_so_luong_sinh_vien_thi_do;

import java.util.Scanner;

public class DemSoLuongSinhVienThiDo {
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
        int maxArray;
        do {
            System.out.print("Nhập số học sinh tối đa: ");
            maxArray = input.nextInt();
            if (maxArray>30){
                System.out.println("Số học sinh không được quá 30 người");
            }
        }while (maxArray<1 || maxArray>30);
        int[] array = new int[maxArray];
        for (int i=0; i<array.length; i++){
            System.out.print("Nhập điểm cho học sinh thứ " + i + " : ");
            array[i] = input.nextInt();
        }
        System.out.print("Danh sách học sinh sau khi nhập: ");
        printArray(array);
        int count=0;
        for (int number:array){
            if(number>=5){
                count++;
            }
        }
        System.out.println();
        System.out.println("Số học sinh đã thi đỗ: " + count);
    }
}
