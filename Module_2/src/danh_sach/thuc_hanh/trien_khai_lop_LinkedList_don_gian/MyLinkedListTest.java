package danh_sach.thuc_hanh.trien_khai_lop_LinkedList_don_gian;

import java.util.LinkedList;
import java.util.Random;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        Random random = new Random();
//        MyLinkedList ll = new MyLinkedList(10);
//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);
//
//        ll.add(0,9);
//        ll.add(0,7);
//        ll.add(0,8);
//        ll.printList();
//        System.out.println("Get: " + ll.get(2));
        LinkedList<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            list.addLast(random.nextInt(100));
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);
//        list.add(0, 123);
//        list.add(12);
//        list.addFirst(213);
//        list.addLast(1);
        System.out.println(list.toString());
//        System.out.println(list.size());
    }
}
