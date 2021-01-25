package danh_sach.bai_tap.trien_khai_phuong_thuc_cua_ListArray;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    static private final int DEFAULT_CAPACITY=10;
    static private final Object[] ELEMENT_DEFAULT_EMPTY = {};
    private Object[] elements = {};

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.elements = new Object[capacity];
    }

    public boolean add(E o){
        if(this.size==elements.length-1){
            increaseList(1);
        }
        this.elements[size] = o;
        this.size++;
        return true;
    }

    public void add(int index, E element){
        if(index<=size){
            if (size==elements.length-1){
                increaseList(1);
            }
            for (int i=size; i>=index; i--){
                elements[i+1] = elements[i];
            }
            elements[index] = element;
            this.size++;
        }else {
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.size);
        }
    }

    public E remove(int index){
        if(index<=size && index>=0){
            Object object = this.elements[index];
            for (int i=index; i<size; i++){
                this.elements[i] = this.elements[i+1];
            }
            this.elements[size] = null;
            this.size--;
            if(this.size<0) this.size=0;
            return (E)object;
        }else {
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.size);
        }

    }

    public void clear(){
        for (Object node : this.elements){
            node = null;
        }
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public Object clone(){
        MyList<?> cloneList = new MyList<>();
        cloneList.elements = this.elements;
        cloneList.size = this.size;
        return cloneList;
    }

    public boolean contains(E o){
        for (Object node : elements){
            if(node==o){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for (int i=0; i<size; i++){
            if(this.elements[i]==o){
                return i;
            }
        }
        return -1;
    }

    public E get(int index){
        if(index<this.size && index>=0){
            return (E)this.elements[index];
        }else{
            throw new IndexOutOfBoundsException("Index: " + index + " Length: " + this.size);
        }
    }

    public void ensureCapacity(int minCapacity){
        int minExpand  = (this.elements != ELEMENT_DEFAULT_EMPTY)?0:DEFAULT_CAPACITY;
        if(minCapacity>minExpand){
            increaseList(minCapacity);
        }
    }

    private void increaseList(int number){
        int newSize = this.elements.length+number;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        String string="";
        for (int i=0; i<this.size; i++){
            string+=this.elements[i];
            if(i<this.size-1){
                string+=", ";
            }
        }
        return "[" + string + "]";
    }
}
