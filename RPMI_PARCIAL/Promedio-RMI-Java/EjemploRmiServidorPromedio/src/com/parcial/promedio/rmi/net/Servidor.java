package com.parcial.promedio.rmi.net;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import com.parcial.promedio.rmi.lib.IRemotaCalculoPromedio;

/**
 * Publica el objeto remoto usando RMI estandar de Java (java.rmi).
 * Crea un RMI Registry (servicio de nombres) en el puerto indicado
 * y registra ahi el objeto remoto con un nombre.
 */
public class Servidor {

    private int puerto = 9008;
    private Registry registro;
    private CalculoRmiPromedioImplem calculoPromedio;

    public Servidor() {
    }

    public void iniciar() throws Exception {
        try {
            calculoPromedio = new CalculoRmiPromedioImplem();
            registro = LocateRegistry.createRegistry(puerto);
            registro.rebind(IRemotaCalculoPromedio.NOMBRE_SERVICIO, calculoPromedio);
            System.out.println("Servidor RMI escuchando en el puerto TCP " + puerto
                    + " con el nombre '" + IRemotaCalculoPromedio.NOMBRE_SERVICIO + "'");
        } catch (RemoteException ex) {
            throw new Exception("Error: No es posible publicar el objeto remoto (" + ex.getMessage() + ")");
        }
    }

    public void detener() {
        try {
            registro.unbind(IRemotaCalculoPromedio.NOMBRE_SERVICIO);
            UnicastRemoteObject.unexportObject(calculoPromedio, true);
            UnicastRemoteObject.unexportObject(registro, true);
        } catch (NoSuchObjectException ex) {
            // ya estaba detenido
        } catch (Exception ex) {
            System.out.println("Error al detener: " + ex.getMessage());
        }
    }
}
