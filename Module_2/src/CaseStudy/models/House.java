package CaseStudy.models;

public class House extends Services {
    private String rank;
    private String description;
    private int numberOfFloors;
    private AccompanyingService accompanyingService;

    public House(String id, String nameService, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, int numberOfFloors, String accompanyingService, int unit, double money) {
        super(id,nameService, areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
        this.numberOfFloors = numberOfFloors;
        this.addAccompanyingService(accompanyingService, unit, money);
    }

    public House(String id, double areaUse, double rentalCosts, int numberMax, String typeRental,
                 String rank, String description, int numberOfFloors) {
        super(id,"house", areaUse, rentalCosts, numberMax, typeRental);
        this.rank = rank;
        this.description = description;
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
                +", Number of floors: " + this.numberOfFloors
                +", Accompanied service: " + accompanyingService.toString();
    }
}
