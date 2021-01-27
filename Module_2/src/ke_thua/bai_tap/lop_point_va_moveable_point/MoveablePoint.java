package ke_thua.bai_tap.lop_point_va_moveable_point;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed  = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{this.xSpeed, this.ySpeed};
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint move(){
        setX(getX()+this.xSpeed);
        setY(getY()+this.ySpeed);
        return this;
    }
    public String toString(){
        return "(" + getX() + "," + getY() + "), speed=(" + this.xSpeed + "," + this.ySpeed + ")";
    }

    public static void main(String[] args) {
//        MoveablePoint point = new MoveablePoint(2,3);
//        System.out.println(point.toString());
//        MoveablePoint point1 = point.move();
//        System.out.println(point1.toString());
        Point point1 = new MoveablePoint(3.0f,2.5f,1.0f,1.0f);
        System.out.println(point1);
        MoveablePoint point = new MoveablePoint();
        MoveablePoint point2 = point.move();
        point2.setSpeed(4.0f,4.0f);
        System.out.println(point.move());
        System.out.println(point2.move());
    }
}
