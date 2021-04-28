package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Argsapp app = Argsapp.of("C:\\Lexino\\learningjava\\job4j_design\\app.properties");
        Class.forName("org.postgresql.Driver");
        String url = app.get("hibernate.connection.url");
        String login = app.get("hibernate.connection.username");
        String password = app.get("hibernate.connection.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
