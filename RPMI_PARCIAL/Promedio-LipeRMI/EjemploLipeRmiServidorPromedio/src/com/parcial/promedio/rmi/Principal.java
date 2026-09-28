package com.parcial.promedio.rmi;

import com.parcial.promedio.rmi.net.Servidor;

public class Principal {

    public static void main(String[] args) {
        Servidor servicio = new Servidor();
        try {
            servicio.iniciar();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
