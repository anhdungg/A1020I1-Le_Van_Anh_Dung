package CaseStudy.models;

import java.util.ArrayList;

public class Villa extends Services {
    private String rank;
    private String description;
    private double areaPool;
    private int numberOfFloors;

    ArrayList<AccompanyingService> list = new ArrayList<>();

    public Villa(String id, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, double areaPool, int numberOfFloors, String nameService, int unit, double money) {
        super(id, "villa", areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
        this.addAccompanyingService(nameService, unit, money);
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
        list.add(new AccompanyingService(nameService, money, unit));
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
                +". Tên dịch vụ: " + this.getNameService()
                +". Diện tích: " + this.getAreaUse()
                +". Chi phí thuê: " + this.getRentalCosts()
                +". Số người tối đa: " + this.getNumberMax()
                +". Kiểu thuê: " + this.getTypeRental()
                +". Tiêu chuẩn phòng: " + this.rank
                +". Tiện nghi khác: " + this.description
                +". Diện tích hồ bơi: " + this.areaPool
                +". Số tầng: " + this.numberOfFloors
                +". Dịch vụ đi kèm: " + this.printService(list);
    }
}
