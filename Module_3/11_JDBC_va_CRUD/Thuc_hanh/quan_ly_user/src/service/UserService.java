package service;

import model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findId(int id);
    boolean save(String name, String email, String country);
    boolean update(int id, String name, String email, String country);
    boolean remove(int id);
    List<User> search(String name);
}
