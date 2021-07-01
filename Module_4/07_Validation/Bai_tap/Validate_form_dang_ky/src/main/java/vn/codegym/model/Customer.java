package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String firstName;
    @NotNull(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String lastName;
    @Pattern(regexp = "^[0][\\d]{9,10}", message = "Số điện thoại phải bắt đầu bằng 0 và có độ dài từ 10-11 con số")
    private String phoneNumber;
    @Min(value = 18, message = "Phải trên 18 tuổi")
    private int age;
    @Email(message = "Email không đúng chuẩn")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
