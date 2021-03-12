package CaseStudy.models;

public class Employee {
    private String name;
    private int yearOld;
    private String address;

    public Employee(String name, int yearOld, String address) {
        this.name = name;
        this.yearOld = yearOld;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", YearOld: " + yearOld + ", Address: " + address ;
    }
}
