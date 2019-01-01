package com.ehealth.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/e_healthprobygeeks", "root", "ptcl");
            } catch (Exception e) {
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
