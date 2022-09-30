package com.example.laboratorio3.entity;

import java.io.Serializable;

public class MascotaEmergencia implements Serializable {

    public MascotaEmergencia(String nombreMasc, String generoMasc, String nombreDuenho, int DNI, String descripcion) {
        this.nombreMasc = nombreMasc;
        this.generoMasc = generoMasc;
        this.nombreDuenho = nombreDuenho;
        this.DNI = DNI;
        this.descripcion = descripcion;
    }

    private String nombreMasc;
    private String generoMasc;
    private String nombreDuenho;
    private int DNI;
    private String descripcion;

    public String getNombreMasc() {
        return nombreMasc;
    }

    public void setNombreMasc(String nombreMasc) {
        this.nombreMasc = nombreMasc;
    }

    public String getGeneroMasc() {
        return generoMasc;
    }

    public void setGeneroMasc(String generoMasc) {
        this.generoMasc = generoMasc;
    }

    public String getNombreDuenho() {
        return nombreDuenho;
    }

    public void setNombreDuenho(String nombreDuenho) {
        this.nombreDuenho = nombreDuenho;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
