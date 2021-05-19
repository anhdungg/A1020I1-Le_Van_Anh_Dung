package repository;

import model.bean.User;
public interface UserRepository {
    User getUserById(int id);
    void insertUserStore(User user);
    void addUserTransaction(User user, int[] permisions);
    void insertUpdateWithoutTransaction();
    void insertUpdateUseTransaction();
}
