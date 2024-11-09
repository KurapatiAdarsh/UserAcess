package com.example.useraccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:postgresql://localhost:5432/UserAccess"; // Update with your DB details
    private static final String USER = "root"; // Update with your DB username
    private static final String PASSWORD = "root"; // Update with your DB password

    // JDBC variables for opening a connection
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            // If connection is not yet established, create a new one
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while establishing database connection", e);
        }
        return connection;
    }
}
