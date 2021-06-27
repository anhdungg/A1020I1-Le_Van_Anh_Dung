package vn.codegym.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không được để trống")
    @Size(min = 0, max = 255, message = "Tối đa 255 kí tự")
    private String title;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Không được để trống")
    private String content;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    public Blog() {
    }

    public Blog( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Blog(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Blog(String title, String content, Date date, Category category) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
