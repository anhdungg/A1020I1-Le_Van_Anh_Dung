package model.bean;

public class Customer {
    private int idCustomer;
    private int idTypeCustomer;
    private String name;
    private String dayOfBirth;
    private String CMND;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer(int idTypeCustomer, String name, String dayOfBirth, String CMND, String phoneNumber, String email, String address) {
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.CMND = CMND;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer(int idCustomer, int idTypeCustomer, String name, String dayOfBirth, String CMND, String phoneNumber, String email, String address) {
        this.idCustomer = idCustomer;
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.CMND = CMND;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", idTypeCustomer=" + idTypeCustomer +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", CMND='" + CMND + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
