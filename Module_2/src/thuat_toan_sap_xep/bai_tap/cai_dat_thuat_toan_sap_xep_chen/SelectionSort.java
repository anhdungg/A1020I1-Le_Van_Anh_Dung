package thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_chen;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private static void sortArray(int[] array){
        for (int i=1; i<array.length;i++){
            int index = i;
            while (array[index]<array[index-1]){
                int a = array[index];
                array[index] = array[index-1];
                array[index-1] = a;
                index--;
                if(index<1) index=1;
            }
        }
    }

    public static void main(String[] args) {
        final int MAX_ARRAY = 2;
        Random random = new Random();
        int[] array = new int[MAX_ARRAY];
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(MAX_ARRAY);
        }
        System.out.println(Arrays.toString(array));
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
