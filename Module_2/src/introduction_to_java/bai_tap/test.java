package introduction_to_java.bai_tap;

import java.util.Scanner;
import java.lang.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number ");
        int number = sc.nextInt();
        String[] ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
                "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(number>0&&number<20){
            System.out.println(ones[number-1]);
        }
        if(number>=20&&number<100){
            double a = (double) number/10;
            double b = (a-(int)a)*10;
            int c = (int)Math.round(b);
            if (c!=0) System.out.println(tens[(int)a-2] + " " + ones[c-1]);
            else System.out.println(tens[(int)a-2]);
        }
    }
}
