package com.parcial.promedio.rmi.net;

import java.io.IOException;
import com.parcial.promedio.rmi.lib.IRemotaCalculoPromedio;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 * Publica el objeto remoto usando LipeRMI.
 * LipeRMI abre un ServerSocket TCP en el puerto indicado.
 */
public class Servidor {

    private int puerto = 9008;
    private CallHandler invocador;
    private Server servidor;
    private CalculoRmiPromedioImplem calculoPromedio;

    public Servidor() {
        invocador = new CallHandler();
        servidor = new Server();
        calculoPromedio = new CalculoRmiPromedioImplem();
    }

    public void iniciar() throws Exception {
        try {
            invocador.registerGlobal(IRemotaCalculoPromedio.class, calculoPromedio);
            servidor.bind(puerto, invocador);
            System.out.println("Servidor LipeRMI escuchando en el puerto TCP " + puerto);
        } catch (LipeRMIException ex) {
            throw new Exception("Error: No es posible invocar metodos remotos");
        } catch (IOException ex) {
            throw new Exception("Error: I/O (" + ex.getMessage() + ")");
        }
    }

    public void detener() {
        servidor.close();
    }
}
