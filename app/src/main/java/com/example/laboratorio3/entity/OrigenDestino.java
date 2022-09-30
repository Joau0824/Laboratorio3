package com.example.laboratorio3.entity;

public class OrigenDestino {

    public OrigenDestino(String origen, String destino, int DNI) {
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setDNI(DNI);
    }


    private String origen;
    private String destino;
    private int DNI;


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
}
