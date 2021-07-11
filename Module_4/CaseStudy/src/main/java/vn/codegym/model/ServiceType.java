package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

    public ServiceType() {
    }

    public ServiceType(String name, Set<Service> services) {
        this.name = name;
        this.services = services;
    }

    public ServiceType(Integer id, String name, Set<Service> services) {
        this.id = id;
        this.name = name;
        this.services = services;
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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
