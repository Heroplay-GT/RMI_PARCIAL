package com.parcial.promedio.rmi.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.parcial.promedio.rmi.lib.DatosPromedio;
import com.parcial.promedio.rmi.lib.IRemotaCalculoPromedio;

/**
 * Implementacion real del servicio. Se ejecuta en el servidor.
 * Extiende UnicastRemoteObject para que se exporte automaticamente
 * (queda escuchando llamadas remotas por TCP).
 */
public class CalculoRmiPromedioImplem extends UnicastRemoteObject implements IRemotaCalculoPromedio {

    private static final long serialVersionUID = 1L;
    private static final float NOTA_MINIMA = 0.0f;
    private static final float NOTA_MAXIMA = 5.0f;

    public CalculoRmiPromedioImplem() throws RemoteException {
        super();
    }

    @Override
    public DatosPromedio calcularPromedio(DatosPromedio datos) throws RemoteException {
        System.out.println("Peticion recibida -> nota1: " + datos.getNota1()
                + ", nota2: " + datos.getNota2() + ", nota3: " + datos.getNota3());

        float nota1 = datos.getNota1();
        float nota2 = datos.getNota2();
        float nota3 = datos.getNota3();

        if (fueraDeRango(nota1) || fueraDeRango(nota2) || fueraDeRango(nota3)) {
            datos.setCondicion("ERROR");
            datos.setObservacion("ERROR: Cada nota debe estar entre " + NOTA_MINIMA + " y " + NOTA_MAXIMA);
            return datos;
        }

        float promedio = (nota1 + nota2 + nota3) / 3f;
        datos.setPromedio(promedio);

        if (promedio < 3.0f) {
            datos.setCondicion("Reprobado (Insuficiente)");
            datos.setObservacion("Es necesario reforzar los temas vistos y buscar apoyo academico.");
        } else if (promedio < 4.0f) {
            datos.setCondicion("Aprobado (Aceptable)");
            datos.setObservacion("Buen desempeno; continua reforzando tus conocimientos.");
        } else if (promedio < 4.5f) {
            datos.setCondicion("Notable (Bueno)");
            datos.setObservacion("Muy buen desempeno academico, sigue asi.");
        } else if (promedio < 5.0f) {
            datos.setCondicion("Sobresaliente (Muy bueno)");
            datos.setObservacion("Excelente rendimiento, estas muy cerca de la nota maxima.");
        } else {
            datos.setCondicion("Excelente (Optimo)");
            datos.setObservacion("Desempeno excepcional. Felicitaciones!");
        }
        return datos;
    }

    private boolean fueraDeRango(float nota) {
        return Float.isNaN(nota) || nota < NOTA_MINIMA || nota > NOTA_MAXIMA;
    }
}
