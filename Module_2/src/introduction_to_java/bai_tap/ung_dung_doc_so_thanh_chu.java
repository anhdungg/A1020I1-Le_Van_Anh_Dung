package introduction_to_java.bai_tap;
import java.util.Scanner;

public class ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberInt;
        String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] two = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] twos = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        do {
            System.out.print("Nhập số tối đa 3 chữ số: ");
            String numberString = input.nextLine();
            numberInt = Integer.parseInt(numberString);
            if(numberInt>=100 && numberInt<=999){
                int[] arrNumber = new int[numberString.length()];
                for(int i=0;i<arrNumber.length; i++){
                    arrNumber[i] = (int)numberString.charAt(i)-48;
                    System.out.println(arrNumber[i]);
                }
                String output = one[arrNumber[0]] + " hundred ";
                if(arrNumber[2]==0){
                    output+=twos[arrNumber[1]];
                }else if(arrNumber[1]==1){
                    output+=two[arrNumber[2]];
                }else if(arrNumber[1]==0){
                    output+=one[arrNumber[2]];
                }else {
                    output+=twos[arrNumber[1]] + "-" + one[arrNumber[2]];
                }
                System.out.println(output);
            }else {
                System.out.println("Lỗi. Hãy nhập lại");
            }
        }
        while (numberInt>999 || numberInt<100);
    }
}
