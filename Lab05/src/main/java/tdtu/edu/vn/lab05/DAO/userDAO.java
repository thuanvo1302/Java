package tdtu.edu.vn.lab05.DAO;

import tdtu.edu.vn.lab05.Model.product;
import tdtu.edu.vn.lab05.Model.user;

import java.sql.*;

public class userDAO {
    private final String jdbcURL = "jdbc:mysql://127.0.0.1:3308/productmanagement";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "root";
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (email, username, password ) VALUES "

            + " (?, ?, ?);";
    private static final String SELECT_USER_BY_EMAIL = "select * from user where username = ? and password = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(user u) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, u.getEmail());
            preparedStatement.setString(2, u.getUserName());
            preparedStatement.setString(3, u.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public user Validate(String username, String password) {
        user u = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String Email = rs.getString("email");
                String Username = rs.getString("username");
                String Password = rs.getString("password");
                u = new user(id, Email, Username, Password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return u;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
