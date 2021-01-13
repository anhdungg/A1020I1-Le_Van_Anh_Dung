package mang_va_phuong_thuc_trong_java.bai_tap.dem_so_lan_xuat_hien_ki_tu_trong_chuoi;

import java.util.Scanner;

public class DemSoLanXuatHienKiTuTrongChuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        String character;
        do {
            System.out.print("Bạn muốn đếm số lần xuất hiện kí tự nào trong chuỗi: ");
            character= input.nextLine();
            if(character.length()>1){
                System.out.println("Chỉ một kí tự");
            }
        }while (character.length()>1);
        int count=0;
        for (int i=0; i<string.length(); i++){
            if(string.charAt(i) == character.charAt(0)){
                count++;
            }
        }
        System.out.println("Số lần suất hiện của kí tự \"" + character + "\": " + count + " lần");
    }
}
