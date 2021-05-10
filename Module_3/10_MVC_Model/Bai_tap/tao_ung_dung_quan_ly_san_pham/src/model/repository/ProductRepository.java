package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findId(int id);
    void save(Product product);
    boolean update(int id, Product product);
    void remove(int id);
    List<Product> search(String name);
}
