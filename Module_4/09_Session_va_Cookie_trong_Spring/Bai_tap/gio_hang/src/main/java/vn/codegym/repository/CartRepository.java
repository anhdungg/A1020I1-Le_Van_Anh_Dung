package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;
import java.util.Set;

public interface CartRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void delete(int id);

    boolean existById(Set<Product> list, int id);

    Product getFirstProduct(Set<Product> list);
}
