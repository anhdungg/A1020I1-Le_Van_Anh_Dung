package xu_ly_ngoai_le_va_debug.bai_tap.su_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class CheckTriangle {

    private static boolean checkTriangle(int a, int b, int c) throws IllegalTriangleException{
        if (a<0 && b<0 && c<0){
            throw new IllegalTriangleException();
        }else if((a+b)<c){
            throw new IllegalTriangleException("Hai cạnh phải lớn hơn cạnh còn lại.");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập cạnh thứ nhất: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.print("Nhập cạnh thứ hai: ");
        int b = input.nextInt();
        input.nextLine();
        System.out.print("Nhập cạnh thứ ba: ");
        int c = input.nextInt();
        input.nextLine();
        try {
            if(checkTriangle(a,b,c)){
                System.out.println("Nhập tam giác thành công.");
            }
        }catch (IllegalTriangleException e){
            e.printStackTrace();
        }
    }
}
