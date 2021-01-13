package mang_va_phuong_thuc_trong_java.bai_tap.tim_phan_tu_lon_nhat_trong_mang_hai_chieu;

import mang_va_phuong_thuc_trong_java.bai_tap.method_matrix_array.MethodMatrixArray;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arrMatrix = MethodMatrixArray.inputArray(input);
        System.out.println("Ma trận sau khi nhập: ");
        MethodMatrixArray.printMatrixArray(arrMatrix);
        int localX = 0;
        int localY = 0;
        int max = arrMatrix[0][0];
        for (int i=0; i<arrMatrix.length; i++){
            for (int j=0; j<arrMatrix[i].length; j++){
                if (max < arrMatrix[i][j]){
                    max = arrMatrix[i][j];
                    localX = j;
                    localY = i;
                }
            }
        }
        System.out.println("Giá trị lớn nhất nằm trong mảng: " + max + ". Có toạ độ x: " + localX + ", y: " + localY);
    }
}
