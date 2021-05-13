package repository;

import model.bean.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findId(int id);
    boolean save(User user);
    boolean update(int id, User user);
    boolean remove(int id);
    List<User> search(String name);
}
