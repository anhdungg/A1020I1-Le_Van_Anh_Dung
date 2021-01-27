package test;

public class Triangle extends Shape {
    private double side;
    private double side1;
    private double side2;

    public Triangle() {
        side = 1.0;
        side1 = 1.0;
        side2 = 1.0;
    }

    public Triangle(String color, double side, double side1, double side2) {
        super(color);
        this.side = side;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getPerimeter(){
        return  side+side1+side2;
    }

    public double getArea(){
        return Math.sqrt(0.5*getPerimeter()*(0.5*getPerimeter()-side) *(0.5*getPerimeter()-side1) * (0.5*getPerimeter()-side2));
    }

    @Override
    public String toString() {
        return super.toString() + " Triangle{" +
                "side=" + side +
                ", side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}
