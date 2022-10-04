package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.laboratorio3.entity.ListaMastEmergencia;
import com.example.laboratorio3.entity.MascotaEmergencia;

import java.util.ArrayList;

public class MainActivityHistorial extends AppCompatActivity {
    historialAdapter adapter =  new historialAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_historial);

        ArrayList<MascotaEmergencia> listmodifi= ListaMastEmergencia.getListaMastEmergencia();
        for(MascotaEmergencia masc: listmodifi){
            if(masc.getRuta().equals("")){
                listmodifi.remove(masc);
            }
        }
        //MascotaEmergencia mascota1 = new MascotaEmergencia("Foster", "Masculino", "David", 74931022, "Nada","Origen:Lince-Destino:Lince");
        //MascotaEmergencia mascota2 = new MascotaEmergencia("Luna", "Masculino", "Pablo", 74931021, "Enferma","Origen:Lince-Destino:San Isidro");
        //MascotaEmergencia mascota3 = new MascotaEmergencia("Tamara", "Femenino", "Javier", 74931024, "Agitada","Origen:Lince-Destino:Magdalena");
        //MascotaEmergencia mascota4 = new MascotaEmergencia("Chester", "Masculino", "Pedro", 74931025, "Cansada","Origen:Lince-Destino:Jesus Maria");
        //listmodifi.add(mascota1);
        //listmodifi.add(mascota2);
        //listmodifi.add(mascota3);
        //listmodifi.add(mascota4);

        if(listmodifi.size()==0) {
            TextView msjehistorial = findViewById(R.id.textViewMsjehistorial);
            msjehistorial.setVisibility(msjehistorial.VISIBLE);
        }
        adapter.setListaMascotas(listmodifi);
        adapter.setContext(MainActivityHistorial.this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityHistorial.this));


    }


}