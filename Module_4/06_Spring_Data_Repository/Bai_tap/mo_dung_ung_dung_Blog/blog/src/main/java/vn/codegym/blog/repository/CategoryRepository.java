package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByURLName(String URLName);
    List<Category> findByURLName(String URLName);
}
