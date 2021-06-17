package vn.picture.model;

import javax.persistence.*;

@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PICTURE_ID")
    private int id;
    private long vote4star;
    private long vote5star;
    private String author;


    public Picture() {
    }

    public Picture(long vote4star, long vote5star, String author) {
        this.vote4star = vote4star;
        this.vote5star = vote5star;
        this.author = author;
    }

    public Picture(int id, long vote4star, long vote5star, String author) {
        this.id = id;
        this.vote4star = vote4star;
        this.vote5star = vote5star;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getVote4star() {
        return vote4star;
    }

    public void setVote4star(long vote4star) {
        this.vote4star = vote4star;
    }

    public long getVote5star() {
        return vote5star;
    }

    public void setVote5star(long vote5star) {
        this.vote5star = vote5star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", vote4star=" + vote4star +
                ", vote5star=" + vote5star +
                ", author='" + author + '\'' +
                '}';
    }
}
