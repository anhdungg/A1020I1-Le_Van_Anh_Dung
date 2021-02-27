package stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_moi_tu_trong_mot_chuoi_su_dung_Map;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        string = string.toLowerCase();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i=0; i<string.length(); i++){
            if(string.charAt(i) != ' ') {
                if (map.containsKey(string.charAt(i))) {
                    int temp = map.get(string.charAt(i));
                    temp++;
                    map.put(string.charAt(i), temp);
                } else {
                    map.put(string.charAt(i), 1);
                }
            }
        }
        System.out.println("Số lần xuất hiện của mỗi từ: ");
        show(map);
    }

    public static void show(Map<Character, Integer> map) {
        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
