package ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
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

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea(){
        double area = this.halfPerimeter()*(this.halfPerimeter()-this.side1)*(this.halfPerimeter()-this.side2)*(this.halfPerimeter()-this.side3);
        return Math.sqrt(area);
    }

    private double halfPerimeter(){
        return 0.5*this.getPerimeter();
    }
    public double getPerimeter(){
        return this.side1+this.side2+this.side3;
    }

    public String toString(){
        return "Triangle: side1=" + this.side1 + ", side2=" + this.side2 + ", side3=" + this.side3 +
                ", perimeter=" + this.getPerimeter() + ", area=" + this.getArea();
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(1,2,3);
        System.out.println(triangle.toString());
    }
}
