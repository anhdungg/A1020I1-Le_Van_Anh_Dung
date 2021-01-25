package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Random random = new Random();
        list.addFirst(123);
        list.addFirst(12);
        list.addFirst(1);
        long start = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            list.addLast(random.nextInt(100));
        }
//        list.addLast(123);
//        list.addLast(12);
//        list.addLast(1);
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);
//        list.printList();
    }
}
