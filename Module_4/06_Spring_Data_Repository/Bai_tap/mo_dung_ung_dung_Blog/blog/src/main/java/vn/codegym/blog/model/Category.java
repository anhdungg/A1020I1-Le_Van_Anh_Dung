package vn.codegym.blog.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 50, message = "Tối đa 255 kí tự")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category() {
    }

    public Category(String name, List<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public Category(Integer id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
