package vn.codegym.concern;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date now = new Date();
        Date dateOfBirth = new Date("1997/05/05");

        long between = now.getTime() - dateOfBirth.getTime();

        int age = (int)(between/(1000 * 60 * 60 * 24)) / 365;
        System.out.println(age);
    }
}
