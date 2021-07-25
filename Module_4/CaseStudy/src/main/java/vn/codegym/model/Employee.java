package vn.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Không được để trống")
    private String name;

    @Past(message = "Ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được để trống")
    private Date dateOfBirth;

    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String idCard;

    @DecimalMin(value = "1", message = "Phải lớn hơn 0")
    @NotNull(message = "Không được để trống")
    private Double salary;

    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String phoneNumber;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String email;

    @NotBlank(message = "Không được để trống")
    private String address;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "educationDegree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_userName", referencedColumnName = "userName")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(String name, Date dateOfBirth, String idCard, Double salary, String phoneNumber, String email,
                    String address, Position position, EducationDegree educationDegree, Division division, User user,
                    Set<Contract> contracts) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public Employee(Integer id, String name, Date dateOfBirth, String idCard, Double salary, String phoneNumber,
                    String email, String address, Position position, EducationDegree educationDegree, Division division,
                    User user, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
