package CaseStudy.models;

import java.util.ArrayList;

public class Room extends Services {
    ArrayList<AccompanyingService> listServiceFree = new ArrayList<>();
    ArrayList<AccompanyingService> listService = new ArrayList<>();

    public Room(String id, double areaUse, double rentalCosts, int numberMax, String typeRental, String nameServiceFree,
                double moneyFree, int unitFree, String nameService, int unit, double money) {
        super(id, "room", areaUse, rentalCosts, numberMax, typeRental);
        this.addAccompanyingServiceFree(nameServiceFree, moneyFree, unitFree);
        this.addAccompanyingService(nameService, money, unit);
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
        listServiceFree.add(new AccompanyingService(nameService, money, uint));
    }

    public void addAccompanyingService(String nameService, double money, int uint){
        listService.add(new AccompanyingService(nameService, money, uint));
    }

    @Override
    public String showInfor() {
        return "Id: " + this.getId()
                +". Tên dịch vụ: " + this.getNameService()
                +". Diện tích: " + this.getAreaUse()
                +". Chi phí thuê: " + this.getRentalCosts()
                +". Số người tối đa: " + this.getNumberMax()
                +". Kiểu thuê: " + this.getTypeRental()
                +". Dịch vụ miễn phí đi kèm: " + this.printService(listServiceFree)
                +". Dịch vụ đi kèm: " + this.printService(listService);
    }
}
