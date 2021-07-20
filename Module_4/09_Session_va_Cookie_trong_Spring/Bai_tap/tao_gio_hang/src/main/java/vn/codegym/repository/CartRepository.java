package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface CartRepository {
    List<Product> findAll();
    
    Product findById(int id);

    void save(Product product);

    void delete(int id);
}
