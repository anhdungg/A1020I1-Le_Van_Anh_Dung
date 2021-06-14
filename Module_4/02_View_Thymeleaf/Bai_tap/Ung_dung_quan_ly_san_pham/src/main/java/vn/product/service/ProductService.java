package vn.product.service;

import vn.product.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void edit(int id, Product product);
    Product findById(int id);
    void delete(int id);
}
