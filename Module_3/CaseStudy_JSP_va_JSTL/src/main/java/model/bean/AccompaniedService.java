package model.bean;

public class AccompaniedService {
    private int id;
    private String name;
    private int price;
    private int unit;
    private String status;

    public AccompaniedService(String name, int price, int unit, String status) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.status = status;
    }

    public AccompaniedService(int id, String name, int price, int unit, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
