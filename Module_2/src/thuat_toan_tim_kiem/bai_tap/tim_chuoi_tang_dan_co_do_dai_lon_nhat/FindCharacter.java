package thuat_toan_tim_kiem.bai_tap.tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.Scanner;

public class FindCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        StringBuilder output = new StringBuilder();
        output.append(string.charAt(0));
        for (int i=1; i<string.length(); i++){
            if((int)string.charAt(i) > (int)output.charAt(output.length()-1)){
                output.append(string.charAt(i));
            }
        }
        System.out.println(output.toString());
    }
}
