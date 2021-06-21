package vn.codegym.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.repository.BlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean save(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return false;
    }
}
