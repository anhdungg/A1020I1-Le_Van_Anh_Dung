package vn.codegym.blog.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.blog.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
