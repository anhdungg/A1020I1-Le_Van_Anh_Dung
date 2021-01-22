package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_ListArray;

public class MyList<E> {
    static public int size;
    static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(int index, E element){
        if(index<elements.length){
            this.elements[index] = element;
        }else {
            throw new IndexOutOfBoundsException("Index<elements.length");
        }
    }
}
