
package com.rmiServer;

/**
 *
 * @author suanny
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.rmiServer.RemoteInterface;
import com.rmiServer.ImplemntInterface;
import com.rmiServer.Server;


public interface RemoteInterface extends Remote {
    void printMsg() throws RemoteException;
    double suma (double a, double b) throws RemoteException;
    double resta (double a, double b) throws RemoteException;
    double multiplicacion (double a, double b) throws RemoteException;
    double division (double a, double b) throws RemoteException;
    public List getUsuarios() throws RemoteException;
    public int insertar(String usuario, String telefono, String direccion, String numtelmovil) throws RemoteException;
}