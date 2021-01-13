package lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_phuong_trinh_bac_hai;

import java.util.Scanner;

class PhuongTrinhBacHai{
    private final double a;
    private final double b;
    private final double c;
    private double delta;

    PhuongTrinhBacHai(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public double getC(){
        return this.c;
    }

    public double getDelta(){
        delta = Math.pow(this.b, 2) - (4 * this.a * this.c);
        return delta;
    }

    public double getRoot1(){
        return ((-b)+Math.sqrt(delta))/(2*this.a);
    }

    public double getRoot2(){
        return ((-b)-Math.sqrt(delta))/(2*this.a);
    }

    public double getRoot3(){
        return -(this.b/(2*this.a));
    }
}
public class XayDungLopPhuongTrinhBacHai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Phương trình bậc hai có dạng ax2+bx+c=0. a!=0");
        double a;
        do {
            System.out.print("Nhập a: ");
            a = input.nextDouble();
            if(a==0){
                System.out.println("a phải khác 0");
            }
        }while (a==0);
        System.out.print("Nhập b: ");
        double b = input.nextDouble();
        input.nextLine();
        System.out.print("Nhập c: ");
        double c = input.nextDouble();
        PhuongTrinhBacHai phuongTrinh = new PhuongTrinhBacHai(a,b,c);
        System.out.println();
        System.out.print("Phương trình sau khi nhập: " + phuongTrinh.getA() + "x2+" + phuongTrinh.getB() + "x+" + phuongTrinh.getC() + "=0");
        double delta = phuongTrinh.getDelta();
        System.out.println();
        System.out.print("Phương trình có delta= " + delta);
        if(delta<0){
            System.out.print(".Phương trình vô nghiệm");
        }else if(delta==0){
            System.out.print(". Phương trình có nghiệm kép x1=x2= " + phuongTrinh.getRoot3());
        }else {
            System.out.println(". Phương trình có hai nghiệm x1= " + phuongTrinh.getRoot1() + ", x2= " + phuongTrinh.getRoot2());
        }
    }
}
