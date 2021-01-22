package danh_sach.thuc_hanh.trien_khai_lop_List_don_gian;

public class MyListTest {
    public static void main(String[] args) {
        MyClass<Integer> listInteger = new MyClass<Integer>();

        listInteger.add(0);
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        System.out.println("Element 2:" + listInteger.get(2));
        System.out.println("Element 5:" + listInteger.get(5));
        System.out.println("Element 1:" + listInteger.get(1));
        System.out.println("Element 3:" + listInteger.get(3));
        System.out.println("Element 7:" + listInteger.get(7));

    }
}
