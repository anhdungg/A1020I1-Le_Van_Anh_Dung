package vn.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.product.model.Product;
import vn.product.repository.ProductRepository;
import vn.product.repository.ProductRepositoryImpl;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void edit(int id, Product product) {
        repository.edit(id, product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
