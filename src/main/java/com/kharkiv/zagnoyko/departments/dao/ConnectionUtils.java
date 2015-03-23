package com.kharkiv.zagnoyko.departments.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Frederick on 22.03.2015.
 */
public final class ConnectionUtils {

    private  ConnectionUtils(){

    }
    public static void rollback(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
