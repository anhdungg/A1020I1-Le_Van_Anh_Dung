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

    @NotNull(message = "Không được để trống")
    @Past(message = "Ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "Sai định dạng")
    private String idCard;

    @NotNull(message = "Không được để trống")
    @DecimalMin(value = "1", message = "Phải lớn hơn 0")
    private Double salary;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$", message = "Sai định dạng")
    private String phoneNumber;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Sai định dạng")
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

    public Employee(Employee employee, User user) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.dateOfBirth = employee.getDateOfBirth();
        this.idCard = employee.getIdCard();
        this.salary = employee.getSalary();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.address = employee.getAddress();
        this.position = employee.getPosition();
        this.educationDegree = employee.getEducationDegree();
        this.division = employee.getDivision();
        this.user = user;
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
