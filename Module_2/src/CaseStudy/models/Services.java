package CaseStudy.models;

abstract public class Services {
    private String nameService;
    private double areaUse;
    private double rentalCosts;
    private int  numberMax;
    private String typeRental;
    private String id;

    public Services(String id, String nameService, double areaUse, double rentalCosts, int numberMax, String typeRental) {
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.numberMax = numberMax;
        this.typeRental = typeRental;
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumberMax() {
        return numberMax;
    }

    public void setNumberMax(int numberMax) {
        this.numberMax = numberMax;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected abstract String showInfor();
}
