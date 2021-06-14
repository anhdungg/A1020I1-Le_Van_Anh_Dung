package vn.product.model;


import javax.validation.constraints.*;

public class Product {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @Positive
    private int unit;
    @Positive
    private int price;
    private String description;

    public Product() {
    }

    public Product(int id, String name, int unit, int price, String description) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
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


}
