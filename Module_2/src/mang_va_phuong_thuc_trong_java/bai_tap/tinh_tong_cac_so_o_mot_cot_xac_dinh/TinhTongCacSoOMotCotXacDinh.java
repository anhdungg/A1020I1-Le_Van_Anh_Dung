package mang_va_phuong_thuc_trong_java.bai_tap.tinh_tong_cac_so_o_mot_cot_xac_dinh;

import mang_va_phuong_thuc_trong_java.bai_tap.method_matrix_array.MethodMatrixArray;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arrMatrix = MethodMatrixArray.inputArray(input);
        System.out.println("Mảng sau khi nhập:");
        MethodMatrixArray.printMatrixArray(arrMatrix);
        int col;
        do {
            System.out.print("Bạn muốn cộng tổng của cột nào: ");
            col = input.nextInt();
            if(col<0){
                System.out.println("Vị trí của cột phải lớn hơn 0");
            }else if (col > arrMatrix.length-1){
                System.out.println("Vị trí của cột phải bé hơn độ dài của mảng");
            }
        }while (col<0 || col>arrMatrix.length-1);
        int sum=0;
        for(int[] array : arrMatrix){
            sum+=array[col];
        }
        System.out.println("Tổng các  số ở cột " + col + " là: " + sum);
    }
}
