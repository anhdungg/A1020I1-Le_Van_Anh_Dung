package mang_va_phuong_thuc_trong_java.thuc_hanh.tim_gia_tri_trong_mang;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Nhập tên bạn muốn tìm: ");
        String name = input.nextLine();
        boolean check = true;
        for (int i=0; i<students.length; i++){
            if(students[i].equals(name)){
                check = false;
                System.out.println("Tên bạn muốn tìm nằm ở vị trí thứ " + (i+1) + " trong mảng");
            }
        }
        if (check){
            System.out.println("Tên bạn muốn tìm không có trong mảng");
        }
    }
}
