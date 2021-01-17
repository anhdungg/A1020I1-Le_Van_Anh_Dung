package ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        this.z = z;
        setXY(x, y);
    }

    public float[] getXYZ(){
        return new float[]{getX(), getY(), this.z};
    }

    public String toString(){
        return "(" + getX() + "," + getY() + "," + this.z + ")";
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D(2,4,6);
        System.out.println(point3D.toString());
        point3D.setXYZ(1,3,5);
        System.out.println(point3D.toString());
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
