package abstract_class_va_interface.bai_tap.trien_khai_interface_Colorable;

import abstract_class_va_interface.bai_tap.trien_khai_interface_Resizeable.*;

public class InterfaceColorable {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(2, "None", false), new Rectangle(3,5, "red", true),
                new Square(5, "black", true)};
        for (Shape shape : shapes){
            Resizeable resizeable;
            if(shape instanceof Circle){
                resizeable = (Circle) shape;
                System.out.println("Circle: area=" + resizeable.getArea());
            }else if(shape instanceof Square){
                Colorable colorable = (Square) shape;
                resizeable = (Square) shape;
                System.out.print("Square: area=" + resizeable.getArea() + ". ");
                colorable.howToColor();
            }else {
                resizeable = (Rectangle) shape;
                System.out.println("Rectangle: area=" + resizeable.getArea());
            }
        }
    }
}
