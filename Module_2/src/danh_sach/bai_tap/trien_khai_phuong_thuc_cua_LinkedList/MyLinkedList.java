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
                this.addFirst(e);
            }else if(index==this.numNode){
                this.addLast(e);
            }else
            {
                Node holderHead = this.head;
                Node[] arrayNode = new Node[index];
                for (int i=0; i<index; i++){
                    arrayNode[i] = holderHead;
                    holderHead = holderHead.next;
                }
                Node temp = new Node(e);
                temp.next = holderHead;
                for (int i=arrayNode.length-1; i>=0; i--){
                    Node temp1 = arrayNode[i];
                    temp1.next = temp;
                    temp = temp1;
                }
                this.head = temp;
            }
            this.numNode++;
        }else{
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.numNode);
        }
    }

    public boolean add(E e){
        this.addLast(e);
        return true;
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
        this.numNode++;
    }

    public E get(int index){
        if(index>=0 && index<this.numNode){
            Node temp = this.head;
            for (int i=0; i<index; i++){
                temp = temp.next;
            }
            return (E)temp.getData();
        }else {
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.numNode);
        }
    }

    public E getFirst(){
        return (E)this.head.getData();
    }

    public E getLast(){
        Node temp = this.head;
        for (int i=0; i<this.numNode-1; i++){
            temp = temp.next;
        }
        return (E)temp.getData();
    }

    public void clear(){
        this.head = null;
        this.last = null;
        this.numNode = 0;
    }
    public E remove(int index){
        if(index<this.numNode && index>=0){
            Node holderHead = this.head;
            Node[] arrayNode = new Node[index];
            for (int i=0; i<index; i++){
                arrayNode[i] = holderHead;
                holderHead = holderHead.next;
            }
            Object returnNode = holderHead.getData();
            holderHead = holderHead.next;
            for(int i=arrayNode.length-1; i>=0; i--){
                Node temp = arrayNode[i];
                temp.next = holderHead;
                holderHead = temp;
            }
            this.head = holderHead;
            this.numNode--;
            return (E)returnNode;
        }else {
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.numNode);
        }
    }

    public boolean remove(Object e){
        Node holderHead =  this.head;
        Node[] arrayNode = new Node[this.numNode];
        for (int i=0; i<this.numNode; i++){
            arrayNode[i] = holderHead;
            if(holderHead.getData() == e){
                holderHead = holderHead.next;
                for (int j = i-1; j>=0; j--){
                    Node temp = holderHead;
                    holderHead = arrayNode[j];
                    holderHead.next = temp;
                }
                this.head = holderHead;
                this.numNode--;
                return true;
            }
            holderHead = holderHead.next;
        }
        return false;
    }

    public int size(){
        return this.numNode;
    }

    public Object clone(){
        MyLinkedList<?> cloneList = new MyLinkedList<>();
        cloneList.head = this.head;
        cloneList.numNode = this.numNode;
        return cloneList;
    }

    public boolean contains(E e){
        Node temp = this.head;
        for (int i=0; i<this.numNode; i++){
            if(temp.getData()==e){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E e){
        Node temp = this.head;
        for(int i=0; i<this.numNode; i++){
            if(temp.getData() == e){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }


    public void printList(){
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    private void printList(Node node){
        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }
    private void beginAdd(E e){
        this.head = new Node(e);
        this.last = this.head;
    }
}
