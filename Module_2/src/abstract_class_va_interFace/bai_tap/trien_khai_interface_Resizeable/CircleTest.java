package abstract_class_va_interface.bai_tap.trien_khai_interface_Resizeable;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        circle.resize(100);
        System.out.println(circle);
    }
}
