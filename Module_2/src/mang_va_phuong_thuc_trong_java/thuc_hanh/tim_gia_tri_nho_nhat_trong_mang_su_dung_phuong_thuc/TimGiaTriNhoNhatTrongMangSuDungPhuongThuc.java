package mang_va_phuong_thuc_trong_java.thuc_hanh.tim_gia_tri_nho_nhat_trong_mang_su_dung_phuong_thuc;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static int minValue(int[] array){
        int min = array[0];
        for (int i=0; i<array.length; i++){
            if(min>array[i]){
                min = array[i];
            }
        }
        return min;
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
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Giá trị nhỏ nhất trong mảng: " + minValue(array));
    }
}
