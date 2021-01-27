package CaseStudy.Task_1.models;

public class Room extends Services {
    AccompanyingService accompanyingService;
//    public Room(String accompanyingService) {
//        this.accompanyingService = accompanyingService;
//    }

    public Room(String id, double areaUse, double rentalCosts, int numberMax, String year, String typeRental,
                String accompanyingService, String nameService, double money, int uint) {
        super(id, "room", areaUse, rentalCosts, numberMax, typeRental);
        this.accompanyingService = new AccompanyingService(nameService, money, uint);
    }

    public String getAccompanyingService() {
        return accompanyingService.toString();
    }

    public void setAccompanyingService(String nameService, double money, int unit) {
        this.accompanyingService.setNameService(nameService);
        this.accompanyingService.setMoney(money);
        this.accompanyingService.setUnit(unit);
    }

    @Override
    protected String showInfor() {
        return "Id: " + this.getId()
                +", Tên dịch vụ: " + this.getNameService()
                +", Diện tích: " + this.getAreaUse()
                +", Chi phí thuê: " + this.getRentalCosts()
                +", Số người tối đa: " + this.getNumberMax()
                +", Kiểu thuê: " + this.getTypeRental()
                +" ,Dịch vụ đi kèm: " + this.accompanyingService;
    }
}
