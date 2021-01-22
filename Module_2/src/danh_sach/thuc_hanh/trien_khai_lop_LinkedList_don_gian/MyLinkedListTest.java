package danh_sach.thuc_hanh.trien_khai_lop_LinkedList_don_gian;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,7);
        ll.add(11,8);
        ll.printList();
        System.out.println("Get: " + ll.get(2));
    }
}
