package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    boolean save(Blog blog);
    boolean delete(Integer id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String value, Pageable pageable);
    Page<Blog> findAllByCategory_Name(String category, Pageable pageable);
}
