/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmiServer;

/**
 *
 * @author Suanny
 */
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplemntInterface{
    public Server() {}
    
    public static void main(String args[]) {
        try {
            ImplemntInterface obj = new ImplemntInterface();
            RemoteInterface obj1 = new ImplemntInterface();
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj,0);
            Registry registry = LocateRegistry.createRegistry(8888);
            registry.bind("metodosRmi", stub);
            System.err.println("Server Listo");
        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}