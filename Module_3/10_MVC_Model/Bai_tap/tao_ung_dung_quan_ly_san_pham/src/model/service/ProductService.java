package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findId(int id);
    boolean save(String name, String unit, String price, String description, String producer);
    boolean update(String id, String name, String unit, String price, String description, String producer);
    void remove(int id);
    List<Product> search(String name);
}
