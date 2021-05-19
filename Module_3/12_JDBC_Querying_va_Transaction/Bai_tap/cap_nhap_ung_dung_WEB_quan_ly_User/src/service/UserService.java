package service;

import model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findId(int id);
    boolean save(String name, String email, String country);
    boolean update(int id, String name, String email, String country);
    boolean remove(int id);
    List<User> findCountry(String country);
    List<User> sortName();
    List<User> findAllSP();
    boolean updateSP(int id, String name, String email, String country);
    boolean removeSP(int id);
    boolean addUserTransaction(String name, String email, String country, int[] permisions);
}
