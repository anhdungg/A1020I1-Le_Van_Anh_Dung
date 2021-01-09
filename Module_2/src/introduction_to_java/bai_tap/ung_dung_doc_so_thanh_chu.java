package introduction_to_java.bai_tap;
import java.util.Scanner;

public class ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberInt;
        do {
            System.out.print("Nhập số tối đa 3 chữ số: ");
            String numberString = input.nextLine();
            numberInt = Integer.parseInt(numberString);
            if(numberInt>=100 && numberInt<=999){
                char[] arrNumber = new char[numberString.length()];
                for(int i=0;i<arrNumber.length; i++){
                    arrNumber[i] = numberString.charAt(i);
                }
                String output="";
                switch (arrNumber[0]){
                    case '1':
                        output += "one hundred ";
                        break;
                    case '2':
                        output += "two hundred ";
                        break;
                    case '3':
                        output += "three hundred ";
                        break;
                    case '4':
                        output += "four hundred ";
                        break;
                    case '5':
                        output += "five hundred ";
                        break;
                    case '6':
                        output += "six hundred ";
                        break;
                    case '7':
                        output += "seven hundred ";
                        break;
                    case '8':
                        output += "eight hundred ";
                        break;
                    case '9':
                        output += "nine hundred ";
                        break;
                }
                if (arrNumber[1]=='1'){
                    switch (arrNumber[2]){
                        case '0':
                            output += "ten ";
                            break;
                        case '1':
                            output += "eleven ";
                            break;
                        case '2':
                            output += "twelve ";
                            break;
                        case '3':
                            output += "thirteen ";
                            break;
                        case '4':
                            output += "fourteen ";
                            break;
                        case '5':
                            output += "fifteen ";
                            break;
                        case '6':
                            output += "sixteen ";
                            break;
                        case '7':
                            output += "seventeen ";
                            break;
                        case '8':
                            output += "eighteen ";
                            break;
                        case '9':
                            output += "nineteen ";
                            break;
                    }
                }else if (arrNumber[1]=='0'){
                    output = getString(arrNumber, output);
                }
                else {
                    switch (arrNumber[1]){
                        case '2':
                            output += "twenty ";
                            break;
                        case '3':
                            output += "thirty ";
                            break;
                        case '4':
                            output += "forty ";
                            break;
                        case '5':
                            output += "fifty ";
                            break;
                        case '6':
                            output += "sixty ";
                            break;
                        case '7':
                            output += "seventy ";
                            break;
                        case '8':
                            output += "eighty ";
                            break;
                        case '9':
                            output += "ninety ";
                            break;
                    }
                    output = getString(arrNumber, output);
                }
                System.out.println(output);
            }else {
                System.out.println("Lỗi. Hãy nhập lại");
            }
        }
        while (numberInt>999 || numberInt<100);
    }

    private static String getString(char[] arrNumber, String output) {
        switch (arrNumber[2]){
            case '1':
                output += "one ";
                break;
            case '2':
                output += "two ";
                break;
            case '3':
                output += "three ";
                break;
            case '4':
                output += "four ";
                break;
            case '5':
                output += "five ";
                break;
            case '6':
                output += "six ";
                break;
            case '7':
                output += "seven ";
                break;
            case '8':
                output += "eight ";
                break;
            case '9':
                output += "nine ";
                break;
        }
        return output;
    }
}
