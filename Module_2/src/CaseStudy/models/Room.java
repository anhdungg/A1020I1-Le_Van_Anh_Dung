package CaseStudy.models;

import java.util.LinkedList;

public class Room extends Services {
    LinkedList<AccompanyingService> listService = new LinkedList<>();

    public Room(String id, double areaUse, double rentalCosts, int numberMax, String typeRental, String nameService,
                double money, int uint) {
        super(id, "room", areaUse, rentalCosts, numberMax, typeRental);
        listService.addLast(new AccompanyingService(nameService, money, uint));
    }

    public void addAccompanyingService(String nameService, double money, int uint){
        listService.addLast(new AccompanyingService(nameService, money, uint));
    }

    public String printService(){
        String string = "";
        for (int i=0; i<listService.size(); i++){
            string+=listService.get(i).toString();
            if(i<listService.size()-1){
                string += ", ";
            }
        }
        return string;
    }
    @Override
    public String showInfor() {
        return "Id: " + this.getId()
                +". Tên dịch vụ: " + this.getNameService()
                +". Diện tích: " + this.getAreaUse()
                +". Chi phí thuê: " + this.getRentalCosts()
                +". Số người tối đa: " + this.getNumberMax()
                +". Kiểu thuê: " + this.getTypeRental()
                +". Dịch vụ miễn phí đi kèm: " + this.printService();
    }
}
