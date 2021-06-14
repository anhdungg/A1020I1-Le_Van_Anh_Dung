package vn.product.repository;

import org.springframework.stereotype.Repository;
import vn.product.model.Product;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Bút", 10, 5000, "Bút mực"));
        list.add(new Product(2, "Thước kẻ", 10, 10000, "Thước kẻ"));
        list.add(new Product(3, "Chuột", 10, 5000000, "Chuột gaming"));
        list.add(new Product(4, "Bàn phím", 5, 7000000, "Bàn phím cơ"));
        list.add(new Product(5, "Cốc", 50, 80000, "Cốc sứ"));
    }
    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        list.set(id, product);
    }

    @Override
    public Product findById(int id) {
        return list.get(id);
    }

    @Override
    public void delete(int id) {
        list.remove(id);
    }
}
