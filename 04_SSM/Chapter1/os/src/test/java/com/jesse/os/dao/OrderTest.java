package com.jesse.os.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderTest {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/os?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEndocing=utf-8";
    private String username = "root";
    private String password = "1234";

    @Test
    public void addOrder(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO orders VALUES('100002','100001',2,2499,now(),null,null,'刘备','13300000000','成都','代发货')");
            statement.execute("UPDATE products SET stock=stock-2 WHERE id='100001'");
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
