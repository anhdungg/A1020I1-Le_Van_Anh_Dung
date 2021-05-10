package model.bean;

public class Product {
    private int id;
    private String name;
    private int unit;
    private int price;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, int unit, int price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
        this.producer = producer;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return this.producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
