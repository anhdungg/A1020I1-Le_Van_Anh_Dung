package vn.picture.repository;

import vn.picture.model.Comment;
import vn.picture.model.Picture;

import java.util.List;

public interface PictureRepository {
    Picture getPicture();
    void vote4star();
    void vote5star();
    void saveComment(String comment);
    List<Comment> getAllComment();
}
