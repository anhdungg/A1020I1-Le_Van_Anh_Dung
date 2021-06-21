package vn.picture.repository;

import vn.picture.model.Comment;
import vn.picture.model.Picture;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class PictureRepositoryImpl implements PictureRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Picture getPicture() {
        TypedQuery<Picture> query = manager.createQuery("select c from Picture c where c.id = :id", Picture.class);
        query.setParameter("id", 3);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void vote4star() {
        Picture picture = this.getPicture();
        picture.setVote4star(picture.getVote4star()+1);
        manager.persist(picture);
    }

    @Override
    public void vote5star() {
        Picture picture = this.getPicture();
        picture.setVote5star(picture.getVote5star()+1);
        manager.persist(picture);
    }

    @Override
    public void saveComment(String comment) {
        if (comment.equals("")){
            return;
        }
        Picture picture = this.getPicture();
        Comment comment1 = new Comment(picture, comment, new Date());
        manager.persist(comment1);
    }

    @Override
    public List<Comment> getAllComment() {
        TypedQuery<Comment> query = manager.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }
}
