package thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_noi_bot;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    private static void bubbleSort(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=0; j<array.length-i; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        final int MAX_ARRAY = 10;
        Random random = new Random();
        int[] array = new int[MAX_ARRAY];
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(MAX_ARRAY);
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
