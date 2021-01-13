package vong_lap_trong_java.bai_tap.hien_thi_20_so_nguyen_to_dau_tien;

public class hien_thi_20_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        int count=0;
        int number=2;
        while (count<20){
            boolean check = true;
            for (int i=2; i<(int)Math.sqrt(number); i++){
                if(number%i==0){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.print(number);
                count++;
                if(count<20){
                    System.out.print(",");
                }
            }
            number++;
        }
    }
}
