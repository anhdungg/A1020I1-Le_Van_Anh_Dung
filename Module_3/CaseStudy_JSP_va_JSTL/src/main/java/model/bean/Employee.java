package model.bean;

public class Employee {
    private int id;
    private String name;
    private int idPosition;
    private int idLevel;
    private int idDepartment;
    private String dayOfBirth;
    private String CMND;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;

    public Employee(String name, int idPosition, int idLevel, int idDepartment, String dayOfBirth, String CMND,
                    double salary, String phoneNumber, String email, String address) {
        this.name = name;
        this.idPosition = idPosition;
        this.idLevel = idLevel;
        this.idDepartment = idDepartment;
        this.dayOfBirth = dayOfBirth;
        this.CMND = CMND;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Employee(int id, String name, int idPosition, int idLevel, int idDepartment, String dayOfBirth, String CMND,
                    double salary, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.idPosition = idPosition;
        this.idLevel = idLevel;
        this.idDepartment = idDepartment;
        this.dayOfBirth = dayOfBirth;
        this.CMND = CMND;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
