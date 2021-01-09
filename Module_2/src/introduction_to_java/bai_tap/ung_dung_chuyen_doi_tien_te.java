package introduction_to_java.bai_tap;

import java.util.Scanner;

public class ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào số tiền bạn muốn chuyển(mệnh giá $): ");
        double moneyInput = input.nextDouble();
        float exchangeRate = 23115.75f;
        System.out.println("Số tiền sau khi chuyển(mệnh giá VND): " + (moneyInput*exchangeRate));
    }
}
