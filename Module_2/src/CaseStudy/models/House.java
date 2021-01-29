package CaseStudy.models;

public class House extends Services {
    private String rank;
    private String description;
    private int numberOfFloors;

    public House(String id, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, int numberOfFloors) {
        super(id,"house", areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.numberOfFloors = numberOfFloors;
    }

//    public House(String rank, String description, int numberOfFloors) {
//        this.rank = rank;
//        this.description = description;
//        this.numberOfFloors = numberOfFloors;
//    }
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
                +". Số tầng: " + this.numberOfFloors;
    }
}
