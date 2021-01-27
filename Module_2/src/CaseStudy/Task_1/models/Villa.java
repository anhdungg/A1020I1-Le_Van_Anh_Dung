package CaseStudy.Task_1.models;

public class Villa extends Services {
    private String rank;
    private String description;
    private double areaPool;
    private int numberOfFloors;

//    public Villa(String id, String nameService, String areaUse, double rentalCosts, int numberMax, String typeRental) {
//        super(id, nameService, areaUse, rentalCosts, numberMax, typeRental);
//    }

    public Villa(String id, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, double areaPool, int numberOfFloors) {
        super(id, "villa", areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
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
    protected String showInfor() {
        return "Id: " + this.getId()
                +", Tên dịch vụ: " + this.getNameService()
                +", Diện tích: " + this.getAreaUse()
                +", Chi phí thuê: " + this.getRentalCosts()
                +", Số người tối đa: " + this.getNumberMax()
                +", Kiểu thuê: " + this.getTypeRental()
                +", Tiêu chuẩn phòng: " + this.rank
                +", Tiện nghi khác: " + this.description
                +", Diện tích hồ bơi: " + this.areaPool
                +", Số tầng: " + this.numberOfFloors;
    }
}
