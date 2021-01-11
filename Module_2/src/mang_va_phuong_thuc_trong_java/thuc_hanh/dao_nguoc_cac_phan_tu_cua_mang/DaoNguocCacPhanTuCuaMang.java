package mang_va_phuong_thuc_trong_java.thuc_hanh.dao_nguoc_cac_phan_tu_cua_mang;

import java.util.Scanner;

public class DaoNguocCacPhanTuCuaMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số phần tử cho mảng: ");
        int max = input.nextInt();
        int[] array = new int[max];
        for (int i=0; i<max; i++){
            System.out.print("Nhập giá trị cho phần tử thứ " + i + ": ");
            array[i] = input.nextInt();
        }
        System.out.print("Mảng bạn vừa nhập: ");
        printArray(array);
        System.out.println();
        System.out.print("Mảng sau khi đảo ngược: ");
        for(int i=0; i<max/2; i++){
            int a = array[i];
            array[i] = array[(max-1)-i];
            array[(max-1)-i] = a;
        }
        printArray(array);
    }
    static void printArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(", ");
            }
        }
    }
}
