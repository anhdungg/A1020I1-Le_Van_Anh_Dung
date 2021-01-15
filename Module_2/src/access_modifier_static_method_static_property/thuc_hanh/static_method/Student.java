package access_modifier_static_method_static_property.thuc_hanh.static_method;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        if(college.equals("BBDIT")){
            college = "CODEGYM";
        }else {
            college = "BBDIT";
        }

    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
