/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gugle
 */
public class MyConnection{
    static String login = "postgres";
    static String password = "123456789";
    static String url = "jdbc:postgresql://localhost:5432/postgres";

    private Statement statement;
    private Connection conexion;

    public MyConnection() throws Exception {
        conexion = null;
        statement = null;

        //Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, login, password);

        if (conexion != null) {
            statement = conexion.createStatement();
            System.out.println("Conexión a base de datos " + url + " ... Ok");
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void setConnection(Connection connection) {
        this.conexion = connection;
    }

    public long update(String sentence) throws Exception {
        return statement.executeUpdate(sentence);
    }
}
