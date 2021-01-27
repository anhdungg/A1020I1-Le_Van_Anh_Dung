package test;

public class TestMovablePoint {
    public static void main(String[] args) {
        Point point1 = new MovablePoint(3.0f,2.5f,1.0f,1.0f);
        System.out.println(point1);
        MovablePoint point = new MovablePoint();
        MovablePoint point2 = point.move();
        point2.setSpeed(4.0f,4.0f);
        System.out.println(point.move());
        System.out.println(point2.move());


    }
}
