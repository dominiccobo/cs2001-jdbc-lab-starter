package com.dominiccobo.teaching;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        loadJDBCDriver();
    }

    private static void loadJDBCDriver() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        MySQLConnection connection = new MySQLConnection("localhost:3306", "myDb", "username", "password");

        Connection connectionInstance = connection.getConnection();

    }

    static class MySQLConnection {

        private final Connection connection;


        MySQLConnection(String host, String database, String username, String password) throws SQLException {

            String hostUrl = String.format("jdbc:mysql://%s/%s", host, database);

            this.connection = DriverManager
                    .getConnection(hostUrl, username, password);


        }

        public Connection getConnection() {
            return connection;
        }
    }
}
