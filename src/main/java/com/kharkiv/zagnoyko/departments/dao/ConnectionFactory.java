package com.kharkiv.zagnoyko.departments.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Frederick on 21.03.2015.
 */
public final class ConnectionFactory {

    private static final String DB_HOST = "localhost:3306";
    private static final String DB_DATABASE = "departmants";

    private ConnectionFactory(){

    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://" + DB_HOST + "/" + DB_DATABASE + "?user=root&password=qwe123";
        return DriverManager.getConnection(url);
    }
}
