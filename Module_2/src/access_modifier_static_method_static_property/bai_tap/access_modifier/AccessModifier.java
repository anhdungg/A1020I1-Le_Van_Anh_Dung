package access_modifier_static_method_static_property.bai_tap.access_modifier;

class Circle{
    private double radius = 1.0;
    private String color = "red";

    Circle(){

    }

    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public String getColor(){
        return this.color;
    }
}

public class AccessModifier {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1.getColor());
        System.out.println(circle1.getRadius());
        Circle circle2 = new Circle(3);
        System.out.println(circle2.getColor());
        System.out.println(circle2.getRadius());
    }
}
