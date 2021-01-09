package introduction_to_java.thuc_hanh.giai_phuong_trinh_bac_nhat;

import java.util.Scanner;

public class giai_phuong_trinh_bac_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Phương trình bậc nhất có dạng ax+b=0. Với a!=0");
        System.out.print("Nhập a: ");
        double numberA = input.nextDouble();
        input.nextLine();
        System.out.print("Nhập b: ");
        double numberB = input.nextDouble();
        if (numberA!=0){
            System.out.println("Phương trình có nghiệm. x=" + (-numberB/numberA));
        }else {
            System.out.println("Lỗi");
        }
    }
}
