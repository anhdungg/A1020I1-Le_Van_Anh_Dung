package lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class XayDungLopFan {
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    XayDungLopFan(){

    }

    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean status){
        this.on = status;
    }
    public boolean getOn(){
        return this.on;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }

    public String getString(){
        if (this.getOn()){
            return "Speed: " + this.getSpeed() + ", color: " + this.getColor() + ", radius: " + this.getRadius() + ". Fan is on";
        }else {
            return "Color: " + this.getColor() + ", radius: " + this.getRadius() + ". Fan is off";
        }
    }

    public static void main(String[] args) {
        XayDungLopFan fan1 = new XayDungLopFan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println("Fan1: " + fan1.getString());
        XayDungLopFan fan2 = new XayDungLopFan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println("Fan2: " + fan2.getString());
    }
}
