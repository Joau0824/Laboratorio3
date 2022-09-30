package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Ambulancias Mascotín");
    }

    public void registro (View view){
        Intent intent = new Intent (this, MainActivityRegistro.class);
        startActivity(intent);

    }

    public void emergencia (View view){
        Intent intent = new Intent (this, MainActivityEmergencia.class);
        startActivity(intent);

    }

    public void historial (View view){
        Intent intent = new Intent (this, MainActivityHistorial.class);
        startActivity(intent);

    }
}