package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository products = new ProductRepositoryImpl();
    private String regexName = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*" +
            "(\\s[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";

    @Override
    public List<Product> findAll() {
        return products.findAll();
    }

    @Override
    public Product findId(int id) {
        return products.findId(id);
    }

    @Override
    public boolean save(String name, String unit, String price, String description, String producer) {
        if (!name.matches(this.regexName)) {
            return false;
        }
        if (!unit.matches("^[0-9]+$")){
            return false;
        }
        if (!price.matches("^[0-9]+$")){
            return false;
        }
        System.out.println(this.findAll().size()+1);
        this.products.save(new Product(this.findAll().size()+1, name, Integer.parseInt(unit), Integer.parseInt(price), description, producer));
        return true;
    }


    @Override
    public boolean update(String id, String name, String unit, String price, String description, String producer) {
        if (!name.matches(this.regexName)) {
            return false;
        }
        if (!unit.matches("^[0-9]+$")){
            return false;
        }
        if (!price.matches("^[0-9]+$")){
            return false;
        }
        return this.products.update(Integer.parseInt(id), new Product(Integer.parseInt(id), name, Integer.parseInt(unit), Integer.parseInt(price), description, producer));
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        return products.search(name);
    }
}
