package com.example.laboratorio3.entity;

import java.util.ArrayList;

public class ListaMastEmergencia {

    public static ArrayList<MascotaEmergencia> listaMastEmergencia=new ArrayList<>();

    public static ArrayList<MascotaEmergencia> getListaMastEmergencia(){
        return listaMastEmergencia;
    }

    public static void addMascotaEmergencia(MascotaEmergencia mascotaEmergencia){
        listaMastEmergencia.add(mascotaEmergencia);
    }

    public static void deleteMascotaEmergencia(MascotaEmergencia mascotaEmergencia){
        listaMastEmergencia.remove(mascotaEmergencia);
    }



}
