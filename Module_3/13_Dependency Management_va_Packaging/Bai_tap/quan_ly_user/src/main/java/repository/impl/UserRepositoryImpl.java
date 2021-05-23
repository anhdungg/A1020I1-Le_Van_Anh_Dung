package repository.impl;

import model.bean.User;
import repository.BaseRepository;
import repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                list.add(user);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public User findId(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select * from user\n" +
                            "where id = ?");
            preparedStatement.setString(1, id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        int row=0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "insert into user(name, email, country)\n" +
                    "\tvalue(?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            row = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row>0;
    }

    @Override
    public boolean update(int id, User user) {
        int row=0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "update user\n" +
                            "set name = ?, email = ?, country = ?\n" +
                            "where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, id+"");

            row = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row>0;
    }

    @Override
    public boolean remove(int id) {
        int row=0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete from user\n" +
                            "where id = ?");
            preparedStatement.setString(1, id+"");

            row = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row>0;
    }

    @Override
    public List<User> findCountry(String country) {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select * from user\n" +
                            "where country like ?");
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setCountry(resultSet.getString("country"));
                list.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email"), resultSet.getString("country")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> findAllSP() {
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("CALL get_user()");
            ResultSet result = callableStatement.executeQuery();
            List<User> list = new ArrayList<>();
            while (result.next()){
                list.add(new User(result.getInt("id"), result.getString("name"),
                        result.getString("email"), result.getString("country")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateSP(int id, User user) {
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("CALL edit_user(?, ?, ?, ?)");
            callableStatement.setInt(1, id);
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());

            int result = callableStatement.executeUpdate();
            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSP(int id) {
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("CALL delete_user(?)");
            callableStatement.setInt(1, id);

            int result = callableStatement.executeUpdate();
            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserTransaction(User user, int[] permisions) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;
        try {
            conn = this.baseRepository.getConnection();
            conn.setAutoCommit(false);
//            if success
            pstmt = conn.prepareStatement("insert into user(name, email, country) value " +
                    "(?,?,?);", Statement.RETURN_GENERATED_KEYS);
            //if fail
//            pstmt = conn.prepareStatement("insert into users(name, email, country) value " +
//                    "(?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            if (rowAffected == 1) {
                //if success
                String sqlPivot = "INSERT INTO use_permision(user_id,permision_id) VALUES(?,?)";
                //if fail
//                String sqlPivot = "INSERT INTO use_permisio(user_id,permision_id) VALUES(?,?)";
                pstmtAssignment = conn.prepareStatement(sqlPivot);
                for (int permisionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException throwables) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(throwables.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (pstmtAssignment != null) {
                    pstmtAssignment.close();
                }
//                if (conn != null) {
//                    conn.close();
//                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
