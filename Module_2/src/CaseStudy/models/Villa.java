package CaseStudy.models;

import java.util.ArrayList;

public class Villa extends Services {
    private String rank;
    private String description;
    private double areaPool;
    private int numberOfFloors;

    AccompanyingService accompanyingService;

    public Villa(String id, String nameService, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, double areaPool, int numberOfFloors, String accompanyingService, int unit, double money) {
        super(id, nameService, areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
        this.addAccompanyingService(accompanyingService, unit, money);
    }

    public Villa(String id, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, double areaPool, int numberOfFloors) {
        super(id, "villa", areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public void addAccompanyingService(String nameService, int unit, double money){
        accompanyingService = new AccompanyingService(nameService, money, unit);
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }


    @Override
    public String showInfor() {
        return "Id: " + this.getId()
                +", Name service: " + this.getNameService()
                +", Area used: " + this.getAreaUse()
                +", Rental costs: " + this.getRentalCosts()
                +", Maximum people: " + this.getNumberMax()
                +", Rent type: " + this.getTypeRental()
                +", Standard room: " + this.rank
                +", Description of other amenities: " + this.description
                +", Area pool: " + this.areaPool
                +", Number of floors: " + this.numberOfFloors
                +", Accompanied service: " + accompanyingService.toString();
    }
}
