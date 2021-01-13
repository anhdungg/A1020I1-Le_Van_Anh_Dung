package lop_va_doi_tuong_trong_java.thuc_hanh.lop_hinh_chu_nhat;

import java.util.Scanner;

class HinhChuNhat{
    double width, height;

    public HinhChuNhat(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getDienTich(){
        return this.width * this.height;
    }

    public double getChuVi(){
        return (this.width+this.height)*2;
    }

    public String display(){
        return "có chiều dài: " + this.width + ", chiều rộng: " + this.height;
    }
}
public class LopHinhChuNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        double width = input.nextDouble();
        input.nextLine();
        System.out.print("Nhập chiều rộng: ");
        double height = input.nextDouble();

        HinhChuNhat chuNhat = new HinhChuNhat(width, height);
        System.out.println("Hình chữ nhật của bạn " + chuNhat.display());
        System.out.println("Diện tích hình chữ nhật: " + chuNhat.getDienTich());
        System.out.println("Chu vi hình chữ nhật: " + chuNhat.getChuVi());
    }
}
