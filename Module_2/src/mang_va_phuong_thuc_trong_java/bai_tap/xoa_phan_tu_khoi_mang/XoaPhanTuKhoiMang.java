package mang_va_phuong_thuc_trong_java.bai_tap.xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
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
        int max=0;
        do {
            System.out.print("Nhập phần số phần tử cho mảng: ");
            max = input.nextInt();
        }while (max<1 || max>20);
        int[] array = new int[max];
        for(int i=0; i<array.length; i++){
            System.out.print("Nhập giá trị cho phần tử thứ " + i + " của mảng: ");
            array[i] = input.nextInt();
        }
        System.out.print("Mảng bạn vừa nhập: ");
        printArray(array);
        System.out.println();
        System.out.print("Nhập ví trí muốn xoá: ");
        int localArray = input.nextInt();
        if(localArray<array.length){
            for (int i=localArray; i<array.length-1; i++){
                array[i] = array[i+1];
            }
            array[array.length-1] = 0;
            System.out.print("Mảng sau khi xoá: ");
            printArray(array);
        }else {
            System.out.println("Ví trí xoá lơn hơn số phần tử mảng");
        }
    }
}
