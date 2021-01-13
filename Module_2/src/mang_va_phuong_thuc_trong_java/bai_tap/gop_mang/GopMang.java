package mang_va_phuong_thuc_trong_java.bai_tap.gop_mang;

import mang_va_phuong_thuc_trong_java.bai_tap.them_phan_tu_vao_mang.ThemPhanTuVaoMang;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxArray=0;
        int[] array1 = new int[0];
        int[] array2 = new int[0];
        for(int i=1; i<3; i++){
            do {
                System.out.print("Nhập số phần tử cho mảng thứ " + i +": ");
                maxArray = input.nextInt();
            }while (maxArray<1);
            if (i == 1) {
                array1 = new int[maxArray];
                for (int j=0; j<array1.length; j++){
                    System.out.print("Nhập giá trị cho phần tử thứ " + j + " của mảng " + i + ":");
                    array1[j] = input.nextInt();
                }
            }else {
                array2 = new int[maxArray];
                for (int j=0; j<array2.length; j++){
                    System.out.print("Nhập giá trị cho phần tử thứ " + j + " của mảng " + i + ":");
                    array2[j] = input.nextInt();
                }
            }

        }
        System.out.print("Mảng 1 sau khi nhập: ");
        ThemPhanTuVaoMang.printArray(array1);
        System.out.println();
        System.out.print("Mảng 2 sau khi nhập: ");
        ThemPhanTuVaoMang.printArray(array2);
        int[] array3 = new int[array1.length+array2.length];
        for (int i=0; i<array3.length; i++){
            if(i<array1.length){
                array3[i] = array1[i];
            }
            else {
                array3[i] = array2[i-array1.length];
            }
        }
        System.out.println();
        System.out.print("Mảng sau khi gộp: ");
        ThemPhanTuVaoMang.printArray(array3);
    }
}
