package repository.impl;

import model.bean.User;
import repository.BaseRepository;
import repository.UserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class UserRepositoryImpl implements UserRepository {
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE(ID serial, NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL, CREATED_DATE timestamp, PRIMARY KEY (ID))";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public User getUserById(int id) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall(
                    "{CALL get_user_by_id(?)}"
            );
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();

            User user = null;
            while (resultSet.next()){
                user = new User(id, resultSet.getString("name"), resultSet.getString("email"),
                        resultSet.getString("country"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertUserStore(User user){
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall(
                    "{CALL insert_user(?, ?, ?)}"
            );
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());

            callableStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;
        try {
            conn = this.baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement("insert into user(name, email, country) value " +
                    "(?,?,?);", Statement.RETURN_GENERATED_KEYS);
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

                // assign permision to user

                String sqlPivot = "INSERT INTO use_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try{
            Connection conn = this.baseRepository.getConnection();
            Statement statement = conn.createStatement();

            PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

            PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE);

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);
            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            psUpdate.setString(2, "Quynh");
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
//            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {

        try {
            Connection conn = baseRepository.getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

            PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE);
            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

//            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }


    }
}
