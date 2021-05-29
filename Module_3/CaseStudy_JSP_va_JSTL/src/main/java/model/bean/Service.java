package model.bean;

public class Service {
    private String id;
    private String name;
    private int area;
    private double rentalCosts;
    private int maximumNumberOfPeople;
    private int idRentalType;
    private int idServiceType;
    private String standard;
    private String description;
    private double poolArea;
    private int numberOfFloors;

    public Service(String name, int area, double rentalCosts, int maximumNumberOfPeople, int idRentalType,
                   int idServiceType, String standard, String description, double poolArea, int numberOfFloors) {
        this.name = name;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.idRentalType = idRentalType;
        this.idServiceType = idServiceType;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String id, String name, int area, double rentalCosts, int maximumNumberOfPeople, int idRentalType,
                   int idServiceType, String standard, String description, double poolArea, int numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.idRentalType = idRentalType;
        this.idServiceType = idServiceType;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public int getIdRentalType() {
        return idRentalType;
    }

    public void setIdRentalType(int idRentalType) {
        this.idRentalType = idRentalType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
