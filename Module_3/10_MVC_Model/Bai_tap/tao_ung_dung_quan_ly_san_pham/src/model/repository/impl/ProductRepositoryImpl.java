package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(productMap.size()+1, new Product(productMap.size()+1, "Bút", 12, 10000, "", "Thiên Long"));
        productMap.put(productMap.size()+1, new Product(productMap.size()+1, "Sách Toán", 5, 50000, "", "Kim Đồng"));
        productMap.put(productMap.size()+1, new Product(productMap.size()+1, "Thước Kẻ", 99, 5000, "", "Thiên Long"));
        productMap.put(productMap.size()+1, new Product(productMap.size()+1, "Bàn Phím", 10, 500000, "", "Fuhlen"));
        productMap.put(productMap.size()+1, new Product(productMap.size()+1, "Chuột chơi game", 99, 250000, "", "Logitech"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findId(int id) {
        return productMap.get(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public boolean update(int id, Product product) {
        if (productMap.containsKey(id)){
            productMap.put(id, product);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : this.findAll()){
            if (product.getName().equals(name)){
                list.add(product);
            }
        }
        return list;
    }
}
