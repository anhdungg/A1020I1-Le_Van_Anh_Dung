package ke_thua.bai_tap.lop_circle_va_lop_Cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radian, String color, double height) {
        super(radian, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea() * this.height;
    }
    @Override
    public String toString() {
        return "Cylinder: " +
                "height=" + height +
                ", radius=" + getRadian() +
                ", color='" + getColor() + "'";
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(12, "red", 15);
        System.out.println(cylinder.toString() + ", volume = " + cylinder.getVolume());
    }
}
