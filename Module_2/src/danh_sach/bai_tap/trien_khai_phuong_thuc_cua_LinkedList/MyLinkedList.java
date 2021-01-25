package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

import java.util.Arrays;

public class MyLinkedList<E> {
    private Node head;
    private Node last;
    private int numNode;

    public MyLinkedList(){
    }

    public void add(int index, E e){
        if(index<=this.numNode){
            if(this.numNode==0){
                this.beginAdd(e);
            }else{
                Node holderHead = this.head;
                for (int i=0; i<index; i++){
                    holderHead = holderHead.next;
                }
                Node temp = new Node(e);
                temp.next = holderHead;
                holderHead = this.head;
                Node temp1 = null;
                for (int i=0; i<index; i++){
                    if(i==0){
                        temp1 = new Node(holderHead.getData());
                    }else {
                        temp1.next = new Node(holderHead.getData());
                        temp1 = temp1.next;
                    }
                    holderHead = holderHead.next;
                }
                temp1.next = temp;
                this.printList(temp1);
            }
            this.numNode++;
        }else{
            throw new IndexOutOfBoundsException("Index: " + index + "Length: " + this.numNode);
        }
    }

    public void addFirst(E e){
        if(this.numNode==0){
            this.beginAdd(e);
        }else{
            Node temp = this.head;
            this.head = new Node(e);
            head.next = temp;
        }
        numNode++;
    }

    public void addLast(E e){
        if(this.numNode==0){
            this.beginAdd(e);
        }else{
            this.last.next = new Node(e);
            this.last =  this.last.next;
        }
//        Node temp = this.head;
//        Node[] nodeArray = new Node[this.numNode+1];
//        for (int i=0; i<this.numNode; i++){
//            nodeArray[i] = temp;
//            temp = temp.next;
//        }
//        nodeArray[nodeArray.length-1] = new Node(e);
//        for (int i=nodeArray.length-1; i>=0; i--){
//            Node node = temp;
//            temp = nodeArray[i];
//            temp.next = node;
//        }
//        this.head = temp;
        this.numNode++;
    }

    public void printList(){
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private void printList(Node node){
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    private void beginAdd(E e){
        this.head = new Node(e);
        this.last = this.head;
    }
}
