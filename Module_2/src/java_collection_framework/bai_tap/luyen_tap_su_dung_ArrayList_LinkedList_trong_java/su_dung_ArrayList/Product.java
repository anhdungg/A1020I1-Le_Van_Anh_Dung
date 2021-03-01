package java_collection_framework.bai_tap.luyen_tap_su_dung_ArrayList_LinkedList_trong_java.su_dung_ArrayList;

public class Product implements Comparable<Product>{
    private int id;
    private String nameProduct;
    private double money;

    public Product(int id, String nameProduct, double money) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.money, o.getMoney());
    }
}
