package thuat_toan_tim_kiem.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.ArrayList;
import java.util.Scanner;

public class FindStringMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.print("Nhập chuỗi: ");
        String str = input.nextLine();
        StringBuilder output = new StringBuilder();
        output.append(str.charAt(0));
        for (int i=1; i<str.length(); i++){
            if ((int) str.charAt(i) <= (int) output.charAt(output.length() - 1)) {
                list.add(output.toString());
                output = new StringBuilder();
            }
            output.append(str.charAt(i));
        }
        list.add(output.toString());
        int max = list.get(0).length();
        int indexMax=0;
        for (int i=0; i<list.size(); i++){
            if(max<list.get(i).length()){
                max = list.get(i).length();
                indexMax = i;
            }
        }
        System.out.println(list.get(indexMax));
    }
}
