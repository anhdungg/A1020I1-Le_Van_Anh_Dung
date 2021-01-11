package mang_va_phuong_thuc_trong_java.thuc_hanh.chuong_trinh_chuyen_doi_nhiet_do;

import java.util.Scanner;

public class ChuongTrinhChuyenDoiNhietDo {
    public static double fahrenheitToCelsius(double fahrenheit){
        return (5.0 / 9) * (fahrenheit - 32);
    }
    public static double celsiusToFahrenheit(double celsius){
        return (9.0 / 5) * celsius + 32;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choise = 0;
        do {
            System.out.print("1. Fahrenheit to Celsius\n" +
                    "2. Celsius to Fahrenheit\n" +
                    "0. Exit\n" +
                    "Please choise: ");
            choise = input.nextInt();
            switch (choise){
                case 1:
                    System.out.print("Enter fahrenheit: ");
                    float fahrenheit = input.nextFloat();
                    System.out.println(fahrenheit + " Fahrenheit = " + fahrenheitToCelsius(fahrenheit) + " Celsius");
                    break;
                case 2:
                    System.out.print("Enter celsius: ");
                    float celsius = input.nextFloat();
                    System.out.println(celsius + " Celsius = " + celsiusToFahrenheit(celsius) + " Fahrenheit");
                    break;
            }
        }while (choise!=0);
    }
}
