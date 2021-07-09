package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    private String userName;

    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_userName"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
//    @OneToMany(mappedBy = "appUser")
//    private Set<AppUserRole> appUserRoles;

    public User() {
    }

    public User(String userName, String password, Employee employee, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
        this.roles = roles;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
