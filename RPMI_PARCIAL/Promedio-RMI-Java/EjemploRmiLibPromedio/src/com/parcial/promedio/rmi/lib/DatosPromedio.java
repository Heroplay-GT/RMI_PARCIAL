package com.parcial.promedio.rmi.lib;

import java.io.Serializable;

/**
 * Objeto que viaja por la red (serializado) entre cliente y servidor.
 */
public class DatosPromedio implements Serializable {

    private static final long serialVersionUID = 1L;

    private float nota1;
    private float nota2;
    private float nota3;
    private float promedio;
    private String condicion;
    private String observacion;

    public DatosPromedio() {
    }

    public DatosPromedio(float nota1, float nota2, float nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
