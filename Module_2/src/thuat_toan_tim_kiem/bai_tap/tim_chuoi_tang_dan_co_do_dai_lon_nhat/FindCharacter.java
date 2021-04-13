package thuat_toan_tim_kiem.bai_tap.tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.ArrayList;
import java.util.Scanner;

public class FindCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list= new ArrayList<>();
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        StringBuilder output = new StringBuilder();
        for (int j=0; j<string.length(); j++) {
            output.append(string.charAt(j));
            for (int i = j; i < string.length(); i++) {
                if ((int) string.charAt(i) > (int) output.charAt(output.length() - 1)) {
                    output.append(string.charAt(i));
                }
            }
            list.add(output.toString());
            output = new StringBuilder();
        }

        int maxLength = list.get(0).length();
        int localMax = 0;
        for (int i=0; i<string.length(); i++){
            if(list.get(i).length()>maxLength){
                maxLength = list.get(i).length();
                localMax = i;
            }
        }
        System.out.println(list.get(localMax));
    }
}
