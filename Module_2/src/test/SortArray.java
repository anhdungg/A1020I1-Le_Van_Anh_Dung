package test;

import java.util.Arrays;
import java.util.Random;

public class SortArray {

    final static private int MAX_ARRAY = 30;
    public static void main(String[] args) {
//        int[] array = new int[MAX_ARRAY];
//        Random random = new Random();
//        for (int i=0;i<array.length;i++){
//            array[i] = random.nextInt(MAX_ARRAY);
//        }
//        System.out.println(Arrays.toString(array));
//        SortArray sortArray = new SortArray();
//        sortArray.quickSort(array);
//        System.out.println(Arrays.toString(array));
    }

    private void quickSort(int[] array){
        int pivot = array.length-1;
        int left = 0;
        int right = pivot-1;
        while (true){
            while(left <= right && array[left] < pivot) left++; // Tìm phần tử >= arr[pivot]
            while(right >= left && array[right] > pivot) right--; // Tìm phần tử <= arr[pivot]
            if (left >= right) break; // Đã duyệt xong thì thoát vòng lặp
            swapIndex(array, left, right); // Nếu chưa xong, đổi chỗ.
            left++; // Vì left hiện tại đã xét, nên cần tăng
            right--; // Vì right hiện tại đã xét, nên cần giảm
        }
        swapIndex(array, left, right);
    }

    private void swapIndex(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
