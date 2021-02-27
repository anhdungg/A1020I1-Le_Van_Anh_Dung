package stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_Stack;

import java.util.LinkedList;
import java.util.Scanner;

public class SwapString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        System.out.println("Chuổi trước khi đảo: " + string);
        LinkedList<Character> list = new LinkedList<>();
        for (int i=0; i<string.length(); i++){
            list.push(string.charAt(i));
        }
        StringBuilder swapString = new StringBuilder();
        for (int i=0;i<string.length(); i++){
            swapString.append(list.pop());
        }
        System.out.println("Chuổi sau khi đảo: " + swapString);
    }
}
