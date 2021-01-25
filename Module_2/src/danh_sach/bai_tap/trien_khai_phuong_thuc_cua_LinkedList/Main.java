package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Random random = new Random();
        list.addFirst(9);
        list.addFirst(12);
        list.addFirst(1);

        list.addLast(2);
        list.addLast(4);
        list.addLast(6);

        list.add(2, 0);

//        list.printList();
    }
}
