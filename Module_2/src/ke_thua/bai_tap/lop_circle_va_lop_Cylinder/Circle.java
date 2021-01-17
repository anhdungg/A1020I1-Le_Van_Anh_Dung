package ke_thua.bai_tap.lop_circle_va_lop_Cylinder;

public class Circle {
    private double radian;
    private String color;

    public Circle() {
    }

    public Circle(double radian, String color) {
        this.radian = radian;
        this.color = color;
    }

    public double getRadian() {
        return radian;
    }

    public void setRadian(double radian) {
        this.radian = radian;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return Math.PI*(Math.pow(this.radian, 2));
    }

    public double getDiameter(){
        return 2*this.radian*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle " +
                "radian=" + radian +
                ", color='" + color + "'" ;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(13, "blue");
        System.out.println(circle.toString() + ", area=" + circle.getArea() + ", diameter=" + circle.getDiameter());
    }
}
