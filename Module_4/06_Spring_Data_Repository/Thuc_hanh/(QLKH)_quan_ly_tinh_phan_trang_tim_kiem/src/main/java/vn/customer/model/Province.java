package vn.customer.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "province")
    private List<Customer> customers;

    public Province() {
    }

    public Province(Integer id) {
        this.id = id;
    }

    public Province(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
