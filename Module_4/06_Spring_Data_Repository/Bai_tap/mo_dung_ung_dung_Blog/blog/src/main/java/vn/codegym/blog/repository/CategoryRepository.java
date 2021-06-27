package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
