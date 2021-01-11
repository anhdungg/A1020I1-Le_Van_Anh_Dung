package vong_lap_trong_java.bai_tap.hien_thi_cac_so_nguyen_to_nho_hon_100;

public class hien_thi_cac_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        int number=2;
        while (number<100){
            boolean check = true;
            for (int i=2; i<number; i++){
                if(number%i==0){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.print(number);
                if(number<97){
                    System.out.print(",");
                }
            }
            number++;
        }
    }
}
