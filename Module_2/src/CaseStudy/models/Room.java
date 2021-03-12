package CaseStudy.models;

public class Room extends Services {
    AccompanyingService freeService;
    AccompanyingService accompanyingService;

    public Room(String id, String nameService, double areaUse, double rentalCosts, int numberMax, String typeRental, String nameServiceFree,
                int unitFree, double moneyFree, String accompanyingService, int unit, double money) {
        super(id, nameService, areaUse, rentalCosts, numberMax, typeRental);
        this.addAccompanyingServiceFree(nameServiceFree, moneyFree, unitFree);
        this.addAccompanyingService(accompanyingService, money, unit);
    }

    public Room(String id, double areaUse, double rentalCosts, int numberMax, String typeRental, String nameServiceFree,
                double moneyFree, int unitFree) {
        super(id, "room", areaUse, rentalCosts, numberMax, typeRental);
        this.addAccompanyingServiceFree(nameServiceFree, moneyFree, unitFree);
    }

    public Room(String id, double areaUse, double rentalCosts, int numberMax, String typeRental) {
        super(id, "room", areaUse, rentalCosts, numberMax, typeRental);
    }

    public void addAccompanyingServiceFree(String nameService, double money, int uint){
        freeService = new AccompanyingService(nameService, money, uint);
    }

    public void addAccompanyingService(String nameService, double money, int uint){
        accompanyingService = new AccompanyingService(nameService, money, uint);
    }

    @Override
    public String showInfor() {
        return "Id: " + this.getId()
                +", Name service: " + this.getNameService()
                +", Area used: " + this.getAreaUse()
                +", Rental costs: " + this.getRentalCosts()
                +", Maximum people: " + this.getNumberMax()
                +", Rent type: " + this.getTypeRental()
                +", Dịch vụ miễn phí đi kèm: " + freeService.toString()
                +", Dịch vụ đi kèm: " + accompanyingService.toString();
    }
}
