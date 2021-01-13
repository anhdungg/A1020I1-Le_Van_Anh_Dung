package mang_va_phuong_thuc_trong_java.bai_tap.method_matrix_array;

import java.util.Scanner;

public class MethodMatrixArray {
    public static int[][] inputArray(Scanner input){
//        Scanner input = new Scanner(System.in);
        System.out.print("Bạn muốn ma trận ?x?: ");
        int x = input.nextInt();
        int y = input.nextInt();
        int[][] arrMatrix = new int[y][x];
        for (int i=0; i<arrMatrix.length; i++){
            for (int j=0; j<arrMatrix[i].length; j++){
                System.out.print("Nhập giá trị cho vị trí y" + i + ":x" + j +" của mảng: ");
                arrMatrix[i][j] = input.nextInt();
            }
        }
        return arrMatrix;
    }
    public static void printMatrixArray(int[][] array){
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
