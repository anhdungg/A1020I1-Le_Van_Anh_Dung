package CaseStudy.models;

import CaseStudy.manage.SortCustomer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private String name;
    private String gender;
    private String dayOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services service;

    public Customer(){

    }

    public Customer(String name, String dayOfBirth, String gender, String idCard, String phoneNumber, String email,
                    String typeCustomer, String address) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public int getYearOfBirth(){
        String year = this.dayOfBirth.substring(this.dayOfBirth.lastIndexOf("/")+1);
        return Integer.parseInt(year);
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String showInfor(){
        return "Name: " + this.name + ", Gender: " + this.gender + ", Day of birth: " + this.dayOfBirth
                +", Id card: " + this.idCard + ", Phone number: " + this.phoneNumber
                + ", Type customer: " +  this.typeCustomer + ", Address: " + this.address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", service=" + service +
                '}';
    }

//    public static void main(String[] args) {
//        ArrayList<Customer> list = new ArrayList<>();
//        SortCustomer sortCustomer = new SortCustomer();
//        Customer customer = new Customer("Dung", "Male", "05/11/1997", "184209423", "0947937297", "ledung.ht17@gmail.com",
//                "VIP", "55 hoang ke viem");
//        list.add(customer);
//        customer = new Customer("Linh", "Female", "14/05/1995", "184209423", "0947937297", "ledung.ht17@gmail.com",
//                "VIP", "55 hoang ke viem");
//        list.add(customer);
//        customer = new Customer("Dung", "Female", "14/05/1995", "184209423", "0947937297", "ledung.ht17@gmail.com",
//                "VIP", "55 hoang ke viem");
//        list.add(customer);
//        customer = new Customer("Dao", "Female", "14/05/1995", "184209423", "0947937297", "ledung.ht17@gmail.com",
//                "VIP", "55 hoang ke viem");
//        list.add(customer);
//        customer = new Customer("Thanh", "Female", "14/05/1995", "184209423", "0947937297", "ledung.ht17@gmail.com",
//                "VIP", "55 hoang ke viem");
//        list.add(customer);
//        System.out.println("Before: ");
//        for (Customer customer1 : list){
//            System.out.println(customer1);
//        }
//        list.sort(sortCustomer);
//        System.out.println("After: ");
//        for (Customer customer1 : list){
//            System.out.println(customer1);
//        }
//    }
}
