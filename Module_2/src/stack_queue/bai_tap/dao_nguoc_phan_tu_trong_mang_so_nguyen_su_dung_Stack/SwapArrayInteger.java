package stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SwapArrayInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số phần tử tối đa cho mảng: ");
        int maxArray = input.nextInt();
        input.nextLine();
        int[] array = new int[maxArray];
        LinkedList<Integer> list =  new LinkedList<>();
        for (int i=0; i<array.length; i++){
            System.out.print("Nhập phần tử thứ " + i + " của mảng: ");
            int value = input.nextInt();
            input.nextLine();
            array[i] = value;
            list.push(value);
        }
        System.out.println("Mảng trước khi đảo: " + Arrays.toString(array));
        for (int i=0; i<array.length; i++){
            array[i] = list.pop();
        }
        System.out.println("Mảng sau khi đảo: " + Arrays.toString(array));
    }
}
