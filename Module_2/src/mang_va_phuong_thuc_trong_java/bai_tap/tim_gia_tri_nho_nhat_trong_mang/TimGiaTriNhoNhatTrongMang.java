package mang_va_phuong_thuc_trong_java.bai_tap.tim_gia_tri_nho_nhat_trong_mang;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxArray;
        do {
            System.out.print("Nhập số phần tử tối đa cho mảng: ");
            maxArray = input.nextInt();
        } while (maxArray < 1);
        int[] array = new int[maxArray];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập giá trị cho phần tử thứ " + i + " của mảng: ");
            array[i] = input.nextInt();
        }
        int min = array[0];
        for (int number : array) {
            if (min > number) {
                min = number;
            }
        }
        System.out.println();
        System.out.print("Mẩng sau khi nhập: ");
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Giá trị nhỏ nhất trong mảng là: " + min);
    }
}
