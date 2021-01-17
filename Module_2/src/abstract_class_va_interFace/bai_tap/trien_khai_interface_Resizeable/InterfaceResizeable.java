package abstract_class_va_interface.bai_tap.trien_khai_interface_Resizeable;

public class InterfaceResizeable {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Rectangle(), new Square()};

        for(Shape shape : shapes){
            System.out.println(shape.toString());
            if(shape instanceof Square){
                Resizeable resizeable = (Square) shape;
                resizeable.resize(200);
                System.out.println(resizeable.toString());
            }

        }
    }
}
