package vn.codegym.blog.service;

import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    boolean save(Category category);
    boolean delete(Integer id);
}
