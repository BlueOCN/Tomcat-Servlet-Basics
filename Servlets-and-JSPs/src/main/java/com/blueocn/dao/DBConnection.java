package com.blueocn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {

    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    private static final String exceptionFormat = "exception in %s, message: %s, code: %s";
    private static Connection connection;

    public static Connection getConnectionToDatabase() {
        if (connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch (SQLException e) {
                        handleSqlException("DBConnection.getConnectionToDatabase", e, LOGGER);
                    }
                }
            }
        }
        return connection;
    }

    public static void handleSqlException(String method, SQLException e, Logger logger) {
        logger.warning(String.format(exceptionFormat, method, e.getSQLState(), e.getErrorCode()));
        throw new RuntimeException(e);
    }
}
