package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.laboratorio3.entity.ListaMastEmergencia;
import com.example.laboratorio3.entity.MascotaEmergencia;

public class MainActivityRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);
    }


    public void guardarRegistro(View view){
        boolean fine = true;
        //obteniendo nombre mascota a guardar
        EditText nomMasco=findViewById(R.id.editTextNomMascota);
        String textStringNomMasc=nomMasco.getText().toString();

        //obteniendo genero a guardar
        Spinner spinnerGenero=findViewById(R.id.spinnerGenero);
        String textGenero=spinnerGenero.getSelectedItem().toString();



        //obteniendo nombre dueño a guardar
        EditText nomDue=findViewById(R.id.editTextNomDue);
        String textnomDue=nomDue.getText().toString();



        //obteniendo dni a guardar
        EditText editTextDni = findViewById(R.id.editTextDni);
        String dnitext = editTextDni.getText().toString();
        int dniint=0;
        try{
            dniint = Integer.parseInt(dnitext);
        }catch (Exception e ){
            fine = false;
            editTextDni.setError("No puede estar vacío");
        }

        //obteniendo descripcion a guardar
        EditText descrip=findViewById(R.id.editTextDesc);
        String textDesc=descrip.getText().toString();


        //se añade a la lista dinamica

        if(fine) {
            MascotaEmergencia mascotaEmer = new MascotaEmergencia(textStringNomMasc, textGenero, textnomDue, dniint, textDesc);
            ListaMastEmergencia.addMascotaEmergencia(mascotaEmer);
            finish();
            Intent intent = new Intent(MainActivityRegistro.this,MainActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(this, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
        }


    }


}