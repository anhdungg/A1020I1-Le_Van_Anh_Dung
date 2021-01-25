package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_ListArray;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(11);
//        list.add(11);
//        list.add(13);
//        list.add(13);
//        list.add(14);
//        list.add(14);
//        list.add(15);
//        list.ensureCapacity(50);
//        list.add(19, 1);
//        System.out.println(list.add(15));
//        list.clear();
//        ArrayList<Integer> list1 = (ArrayList<Integer>)list.clone();
//        list1.clone();
//        System.out.println(list.indexOf(99));
//        System.out.println(list.toString());
        Random random = new Random();
        MyList<Integer> list = new MyList<>();
        for (int i=0; i<11; i++){
            list.add(random.nextInt(10));
        }
//        MyList<Integer> list1 = (MyList<Integer>)list.clone();
//        System.out.println(list.size());
        System.out.println(list.toString());
        list.clear();
//        System.out.println(list.remove(2));
        System.out.println(list.toString());
        for (int i=0; i<12; i++){
            list.add(random.nextInt(10));
        }
        System.out.println(list.toString());
    }
}
