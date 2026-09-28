package com.parcial.promedio.rmi.lib;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota compartida por cliente y servidor.
 * En RMI estandar DEBE extender java.rmi.Remote y cada metodo
 * DEBE declarar RemoteException.
 */
public interface IRemotaCalculoPromedio extends Remote {

    /** Nombre con el que se publica el objeto en el RMI Registry. */
    String NOMBRE_SERVICIO = "CalculoPromedio";

    public DatosPromedio calcularPromedio(DatosPromedio datos) throws RemoteException;
}
