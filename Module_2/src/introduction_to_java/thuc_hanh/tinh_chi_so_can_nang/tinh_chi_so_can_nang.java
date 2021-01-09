package introduction_to_java.thuc_hanh.tinh_chi_so_can_nang;

import java.util.Scanner;

public class tinh_chi_so_can_nang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập cân năng(đơn vị kg): ");
        float weight = input.nextFloat();
        input.nextLine();
        System.out.print("Nhập chiều cao(đơn vị m): ");
        float height = input.nextFloat();
        double result = weight/Math.pow(height, 2);
        String output = "Chỉ số BMI của bạn: " + ((float)Math.round(result*100)/100);
        if (result<18.5){
            output += ". Bạn đang thiếu cân";
        }else if(result<25){
            output += ". Bạn bình thường";
        }else if(result<30){
            output += ". Bạn đang thừa cân";
        }else {
            output += ". Bạn đang béo  phì";
        }
        System.out.println(output);
    }
}
