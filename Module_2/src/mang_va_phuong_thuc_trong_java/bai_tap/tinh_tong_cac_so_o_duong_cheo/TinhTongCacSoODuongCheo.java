package mang_va_phuong_thuc_trong_java.bai_tap.tinh_tong_cac_so_o_duong_cheo;

import mang_va_phuong_thuc_trong_java.bai_tap.method_matrix_array.MethodMatrixArray;

import java.util.Scanner;

public class TinhTongCacSoODuongCheo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arrMatrix = MethodMatrixArray.inputArray(input);
        System.out.println("Mảng sau khi nhập: ");
        MethodMatrixArray.printMatrixArray(arrMatrix);
        int sum=0;
        for (int i=0; i<arrMatrix.length; i++){
            sum+=arrMatrix[i][i];
        }
        System.out.println("Tổng các số ở đường chéo từ trái qua phải: " + sum);
        sum=0;
        for(int i=0; i<arrMatrix.length; i++){
            sum+=arrMatrix[i][2-i];
        }
        System.out.println("Tổng các số ở đường chéo từ phải qua trái: " + sum);
    }
}
