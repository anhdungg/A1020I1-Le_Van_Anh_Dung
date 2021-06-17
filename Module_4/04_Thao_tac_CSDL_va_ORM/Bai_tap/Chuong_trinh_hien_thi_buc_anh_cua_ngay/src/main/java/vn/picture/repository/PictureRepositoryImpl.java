package vn.picture.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.picture.hibernate.HibernateUtil;
import vn.picture.model.Comment;
import vn.picture.model.Picture;

import java.util.Date;
import java.util.List;

@Repository
public class PictureRepositoryImpl implements PictureRepository{

    @Override
    public Picture getPicture() {
        Session session = null;
        Picture picture = null;
        try{
            session = HibernateUtil.sessionFactory.openSession();
            picture = session.get(Picture.class, 3);
        } finally {
            if (session!= null){
                session.close();
            }
        }
        return picture;
    }

    @Override
    public void vote4star() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Picture picture = session.get(Picture.class, 3);
            picture.setVote4star(picture.getVote4star()+1);
            session.update(picture);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void vote5star() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Picture picture = session.get(Picture.class, 3);
            picture.setVote5star(picture.getVote5star()+1);
            session.update(picture);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void saveComment(String comment) {
        if (comment.equals("")){
            return;
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Picture picture = session.get(Picture.class, 3);
            Comment comment1 = new Comment(picture, comment, new Date());
            session.save(comment1);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Comment> getAllComment() {
        Session session = null;
        List<Comment> list = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            list = session.createQuery("FROM Comment").getResultList();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
