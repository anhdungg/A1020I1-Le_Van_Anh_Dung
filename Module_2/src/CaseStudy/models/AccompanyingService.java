package CaseStudy.models;

public class AccompanyingService {
    private String nameService;
    private double money;
    private int unit;

    public AccompanyingService(String nameService, double money, int unit) {
        this.nameService = nameService;
        this.money = money;
        this.unit = unit;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String toString(){
        return this.nameService + ", Unit: " + this.unit + ", Money: " + this.money;
    }
}
