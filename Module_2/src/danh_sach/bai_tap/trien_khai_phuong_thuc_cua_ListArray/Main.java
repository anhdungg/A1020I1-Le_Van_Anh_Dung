package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_ListArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(12);
        list.add(11);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(6, 90);
        System.out.println(list.toString());
    }
}
