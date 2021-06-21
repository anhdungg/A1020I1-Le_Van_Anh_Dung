package vn.codegym.blog.service;

import vn.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    boolean save(Blog blog);
    boolean delete(Integer id);
}
