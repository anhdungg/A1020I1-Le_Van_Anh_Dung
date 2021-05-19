package repository;

import model.bean.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findId(int id);
    boolean save(User user);
    boolean update(int id, User user);
    boolean remove(int id);
    List<User> findCountry(String country);
    List<User> findAllSP();
    boolean updateSP(int id, User user);
    boolean removeSP(int id);
    boolean addUserTransaction(User user, int[] permisions);
}
