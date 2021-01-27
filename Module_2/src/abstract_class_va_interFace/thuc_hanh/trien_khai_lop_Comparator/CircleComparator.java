package abstract_class_va_interface.thuc_hanh.trien_khai_lop_Comparator;

import abstract_class_va_interface.thuc_hanh.trien_khai_interface_Comparable.*;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) return 1;
        else if (o1.getRadius() < o2.getRadius()) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Circle[] circles = {new Circle(3.6), new Circle(), new Circle(3.5,"red",false)};

        System.out.println("Pre-sorted: ");
        for (Circle circle : circles){
            System.out.println(circle);
        }
        Comparator comparator = new CircleComparator();
        Arrays.sort(circles,comparator);
        System.out.println("After-sorted: ");
        for (Circle circle : circles){
            System.out.println(circle);
        }
    }
}
