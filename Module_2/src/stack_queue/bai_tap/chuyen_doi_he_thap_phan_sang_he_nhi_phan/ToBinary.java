package stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class ToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số hệ thập phân: ");
        int number = input.nextInt();
        int temp = number;
        input.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (temp>0){
            stack.push(temp%2);
            temp = temp/2;
        }
        StringBuilder string = new StringBuilder();
        int maxStack = stack.size();
        for(int i=0; i<maxStack; i++){
            string.append(stack.pop());
        }
        System.out.println(number + " = " + string);
    }
}
