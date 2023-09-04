package jdbc;

import password_encryption.CustomEncryptor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OSBB_v4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0xE11700x11000x11200x10200x5400x5300x10700x6200x6000x10800xWw";
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, CustomEncryptor.decrypt(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}