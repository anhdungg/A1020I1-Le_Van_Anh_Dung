package test;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Triangle triangle1 = new Triangle();
        System.out.println("input the color of shape: ");
        triangle1.setColor(input.nextLine());
        System.out.print("input the first edge: ");
        triangle1.setSide(input.nextDouble());
        System.out.print("input the second edge: ");
        triangle1.setSide1(input.nextDouble());
        System.out.print("input the third edge: ");
        triangle1.setSide2(input.nextDouble());
        System.out.println("Perimeter of triangle is: " + triangle1.getPerimeter());
        System.out.println("Area of triangle is: " + triangle1.getArea());
        System.out.println(triangle1);


    }
}
