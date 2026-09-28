package com.parcial.promedio.rmi.lib;

/**
 * Interfaz remota compartida por cliente y servidor.
 * Con LipeRMI es una interfaz Java normal: no extiende Remote
 * ni declara RemoteException.
 */
public interface IRemotaCalculoPromedio {

    public DatosPromedio calcularPromedio(DatosPromedio datos);
}
