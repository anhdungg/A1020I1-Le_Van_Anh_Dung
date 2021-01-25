package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

import java.util.Arrays;

public class MyLinkedList<E> {
    private Node head;
    private Node last;
    private int numNode;

    public MyLinkedList(){
    }

    public void add(int index, E element){
        if(index<=this.numNode){

        }else{
            throw new IndexOutOfBoundsException("Index: " + index + "Length: " + this.numNode);
        }
    }

    public void addFirst(E e){
        Node temp = this.head;
        this.head = new Node(e);
        head.next = temp;
//        System.out.print(this.head + "  ");
//        System.out.println(this.head.next + "  ");
        numNode++;
    }

    public void addLast(E e){
        Node temp = this.head;
        Node[] nodeArray = new Node[this.numNode+1];
        for (int i=0; i<this.numNode; i++){
            nodeArray[i] = temp;
            temp = temp.next;
        }
        nodeArray[nodeArray.length-1] = new Node(e);
//        System.out.println(Arrays.toString(nodeArray));
        for (int i=nodeArray.length-1; i>=0; i--){
            Node node = temp;
            temp = nodeArray[i];
            temp.next = node;
        }
        this.head = temp;
        this.numNode++;
    }

    @Override
    public String toString() {
        String string = "";
        Node temp = head;
        if(temp != null) {
            for (int i = 0; i < this.numNode; i++) {
                string+=temp.next;
                if(i<this.numNode-1){
                    string+=", ";
                }
            }
        }
        return string;
    }

    public void printList(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
