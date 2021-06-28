package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    boolean existsByURLTitle(String URLTitle);
    Page<Blog> findAllByTitleContaining(String value, Pageable pageable);
    Page<Blog> findAllByCategory_Name(String category, Pageable pageable);
    Blog findByURLTitle(String URLTitle);
}
