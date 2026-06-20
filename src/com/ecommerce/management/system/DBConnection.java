package com.ecommerce.management.system;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerce",
                    "root",
                    "yeshu123");

            

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}

