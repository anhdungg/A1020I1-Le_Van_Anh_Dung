package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table
public class Service {
    @Id
    @Column(length = 50)
    @Pattern(regexp = "^(DV-)[\\d]{4}$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String id;

    @NotBlank(message = "Không được để trống")
    private String name;

    @DecimalMin(value = "0.0", message = "Không đúng định dạng")
    @NotNull(message = "Không được để trống")
    private Double area;

    @DecimalMin(value = "0.0", message = "Không đúng định dạng")
    @NotNull(message = "Không được để trống")
    private Double cost;

    @Positive(message = "Không đúng định dạng")
    @NotNull(message = "Không được để trống")
    private Integer maxPeople;

    @NotBlank(message = "Không được để trống")
    private String standardRoom;

    private String descriptionOtherConvenience;

    @DecimalMin(value = "0.0", message = "Không đúng định dạng")
    @NotNull(message = "Không được để trống")
    private Double poolArea;

    @PositiveOrZero(message = "Sai địng dạng")
    @NotNull(message = "Không được để trống")
    private Integer numberOfFloors;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "serviceType_id", referencedColumnName = "id")
    private ServiceType serviceType;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rentType_id", referencedColumnName = "id")
    private RentType rentType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Service() {
    }

    public Service(String name, Double area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience,
                   Double poolArea, Integer numberOfFloors, ServiceType serviceType, RentType rentType, Set<Contract> contracts) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public Service(String id, String name, Double area, Double cost, Integer maxPeople, String standardRoom,
                   String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, ServiceType serviceType,
                   RentType rentType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
