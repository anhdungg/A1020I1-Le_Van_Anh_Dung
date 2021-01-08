package introduction_to_java;
import java.util.Scanner;

public class ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberInt=0;
        do {
            System.out.print("Nhập số tối đa 3 chữ số:");
            String numberString = input.nextLine();
            numberInt = Integer.parseInt(numberString);
            if(numberInt>100 && numberInt<999){
                char[] arrNumber = new char[numberString.length()];
                for(int i=0;i<arrNumber.length; i++){
                    arrNumber[i] = numberString.charAt(i);
                }
                String output="";
                for (int i=0; i<3; i++){
                    if(i==1) {
                        switch (arrNumber[i]) {
                            //                        case '0':
                            //                            output+="zero";
                            //                            break;
                            case '1':
                                output += "one";
                                break;
                            case '2':
                                output += "two";
                                break;
                            case '3':
                                output += "three";
                                break;
                            case '4':
                                output += "four";
                                break;
                            case '5':
                                output += "five";
                                break;
                            case '6':
                                output += "six";
                                break;
                            case '7':
                                output += "seven";
                                break;
                            case '8':
                                output += "eight";
                                break;
                            case '9':
                                output += "nine";
                                break;
                        }
                    }
                    if (i==0){
                        output+=" hundred and ";
                    }
                }
                System.out.println(output);
            }else {
                System.out.println("Lỗi. Hãy nhập lại");
            }
        }
        while (numberInt>999 || numberInt<100);
    }
}
