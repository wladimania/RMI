/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmiServer;

import com.db.MyConnection;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author gugle
 */
// Implementing the remote interface
public class ImplemntInterface implements RemoteInterface {

    //Connection connection;
    boolean okConection = false;
    ArrayList results = null;

    public ImplemntInterface() {

    }

    // Implementing the interface method
    @Override
    public void printMsg() {
        System.out.println("This is an example RMI program");
    }

    @Override
    public double suma(double primero, double segundo) {
        return primero + segundo;
    }

    @Override
    public double resta(double primero, double segundo) {
        return primero - segundo;
    }

    @Override
    public double multiplicacion(double primero, double segundo) {
        return primero * segundo;
    }

    @Override
    public double division(double primero, double segundo) {
        return primero / segundo;
    }

    @Override
    public ArrayList getUsuarios() throws RemoteException {
        //ArrayList results = null;
        try {
            MyConnection myConnection = new MyConnection();
            Statement statement;
            ResultSet resultSet;
            statement = myConnection.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM usuarios");
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            results = new ArrayList();

            while (resultSet.next()) {
                HashMap row = new HashMap();
                results.add(row);

                for (int i = 1; i <= columns; i++) {
                    row.put(md.getColumnName(i), resultSet.getObject(i));
                }
            }
            return results;

        } catch (Exception ex) {
            System.out.println("Error al consultar datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int insertar(String usuario, String clave, String email, String telmovil) throws RemoteException {
        try {
            MyConnection myConnection = new MyConnection();
            Statement statement;
            statement = myConnection.getConnection().createStatement();
            return statement.executeUpdate("INSERT INTO('" + usuario + "','" + clave + "','" + email + "', '" + telmovil + "');");
        } catch (Exception ex) {
            System.out.println("Error al insertar datos: " + ex.getMessage());
            return -1;
        }
    }
}
