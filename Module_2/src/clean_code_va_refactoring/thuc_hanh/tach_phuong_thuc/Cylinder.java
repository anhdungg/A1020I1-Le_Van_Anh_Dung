package clean_code_va_refactoring.thuc_hanh.tach_phuong_thuc;

public class Cylinder {
    public static double getVolume(int radius, int height){
        return getPerimeter(radius)*height+2*getArea(radius);
    }

    public static double getArea(int radius){
        return Math.PI*Math.pow(radius, 2);
    }

    public static double getPerimeter(int radius){
        return 2*Math.PI*radius;
    }

    public static void main(String[] args) {
        System.out.println(getVolume(9, 20));
    }
}
