package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

public class Node {
    public Node next;
    private Object data;
    protected Node(Object data){
        this.data = data;
    }

    protected Object getData(){
        return this.data;
    }
}
