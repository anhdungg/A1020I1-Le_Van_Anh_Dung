package stack_queue.bai_tap.kiem_tra_chuoi_Palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        string = string.toLowerCase();
        int temp=string.length()/2;
        Queue<Character> queue = new LinkedList<>();
        for (int i=0; i<temp; i++){
            queue.offer(string.charAt(i));
        }
        boolean check = true;
        int maxQueue = queue.size();
        for (int i=0; i<maxQueue; i++) {
            if(queue.peek() != string.charAt((string.length()-1)-i)){
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("Is Palindrome");
        }else {
            System.out.println("Is not Palindrome");
        }
    }
}
