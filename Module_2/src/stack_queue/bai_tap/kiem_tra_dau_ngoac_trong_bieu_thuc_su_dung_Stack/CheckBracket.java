package stack_queue.bai_tap.kiem_tra_dau_ngoac_trong_bieu_thuc_su_dung_Stack;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập biểu thức: ");
        String expression = input.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean check;
        for (int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '('){
                stack.push(expression.charAt(i));
            }else if(expression.charAt(i) == ')'){
                if(stack.isEmpty()){
                    check = false;
                    break;
                }else {
                    stack.pop();
                }
            }
        }
        check = stack.isEmpty();
        if(check){
            System.out.println("Well");
        }else {
            System.out.println("???");
        }
    }
}
