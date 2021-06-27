package vn.codegym.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean save(Category category) {
        categoryRepository.save(category);
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return false;
    }
}
