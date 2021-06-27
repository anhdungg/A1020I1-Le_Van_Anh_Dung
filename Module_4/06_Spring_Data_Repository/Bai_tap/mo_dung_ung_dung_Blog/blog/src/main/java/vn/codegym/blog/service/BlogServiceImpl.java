package vn.codegym.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.repository.BlogRepository;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean save(Blog blog) {
        Date now = new Date();
        blog.setDate(now);
        blogRepository.save(blog);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        blogRepository.deleteById(id);
        return false;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String value, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(value, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Name(String category, Pageable pageable) {
        return blogRepository.findAllByCategory_Name(category, pageable);
    }
}
