package vn.product.repository;

import vn.product.model.Product;

import java.util.List;


public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);
    void edit(int id, Product product);
    Product findById(int id);
    void delete(int id);
}
