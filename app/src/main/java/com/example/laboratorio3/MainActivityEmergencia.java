package com.example.laboratorio3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.laboratorio3.entity.ListaMastEmergencia;
import com.example.laboratorio3.entity.MascotaEmergencia;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivityEmergencia extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private double destinolat = 0.0;
    private double destinolong = 0.0;
    private final LatLng ORIGEN = new LatLng(-12.084538, -77.031396);
    private int minutos;
    private int hor,min,seg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_emergencia);


        //carga el mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapGoogle);
        mapFragment.getMapAsync(this);

        //contador
        TextView textViewContador = findViewById(R.id.contador);
        ContadorViewModel contadorViewModel =
                new ViewModelProvider(this).get(ContadorViewModel.class);
        contadorViewModel.getContador().observe(this,
                contador -> {
                    if (contador > 0) {
                        seg=contador;
                        hor=seg/3600;
                        seg %=3600;
                        min =seg/60;
                        seg %=60;
                        textViewContador.setText("La ambulancia llegará en "+hor+"h "+min+"m "+seg+"s");
                    } else {
                        textViewContador.setText("La ambulancia ha llegado a su destino");
                    }
                });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        googleMap.addMarker(new MarkerOptions()
                .position(ORIGEN)
                .title("Clínica Mascotín"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ORIGEN,12));

        if(destinolat!=0.0 && destinolong!=0.0){
            LatLng destino = new LatLng(destinolat, destinolong);
            googleMap.addMarker(new MarkerOptions()
                    .position(destino)
                    .title("Marker in Sydney"));

        }

    }


    public void buttonGetCoordinates(View view){
        Geocoder geocoder = new Geocoder(this);
        List<Address>  addressList;
        EditText editTextDestin = findViewById(R.id.Destino);
        EditText editTextDni=findViewById(R.id.DNI);
        TextView textView = findViewById(R.id.contador);
        Boolean validacion=true;
        Boolean dniEncon=false;
        //validacion de datos

        if(editTextDestin.getText().toString().equals("")){
            editTextDestin.setError("Debe ingresar un destino");
            validacion=false;
        }
        if (!editTextDestin.getText().toString().contains("Lince") &&
                !editTextDestin.getText().toString().contains("San Isidro") &&
                !editTextDestin.getText().toString().contains("Magdalena") &&
                !editTextDestin.getText().toString().contains("Jesus Maria")){
            editTextDestin.setError("El destino ingresado no es valido");
            validacion=false;
        }

        if(editTextDni.getText().toString() == null || editTextDni.getText().toString().length() != 8 || editTextDni.getText().toString().equals("")){
            editTextDni.setError("Debe ingresar un dni valida de 8 caracteres");
            validacion=false;
        }

        //validacion de que exista el dni en el registro
        ArrayList<MascotaEmergencia> list= ListaMastEmergencia.getListaMastEmergencia();

        for (MascotaEmergencia obj:list){
            if(editTextDni.getText().toString().equals(Integer.toString(obj.getDNI()))){
                dniEncon=true;
            }
        }

        if (!dniEncon) {
            editTextDni.setError("DNI no registrado");
            validacion = false;
        }

        if(dniEncon && validacion){
            //asignacion de la ruta a la mascota
            for (MascotaEmergencia obj:list){
                if(editTextDni.getText().toString().equals(Integer.toString(obj.getDNI()))){
                    obj.setRuta("Origen:Lince - " +"Destino:"+editTextDestin.getText().toString());

                }
            }
            //seteo del tiempo de viaje (contador)
            if(editTextDestin.getText().toString().contains("Lince")){
                minutos=10;
            }
            if(editTextDestin.getText().toString().contains("San Isidro")){
                minutos=15;
            }
            if(editTextDestin.getText().toString().contains("Magdalena")){
                minutos=20;
            }
            if(editTextDestin.getText().toString().contains("Jesus Maria")){
                minutos=25;
            }
            ContadorViewModel contadorViewModel = new ViewModelProvider(this).get(ContadorViewModel.class);
            contadorViewModel.contarNto0(minutos*60);
        }


        //try {
        //    System.out.println(editTextDestin.getText().toString());
        //    addressList = geocoder.getFromLocationName(editTextDestin.getText().toString(), 1);

        //    if (addressList != null){
        //        destinolat = addressList.get(0).getLatitude();
        //        destinolong = addressList.get(0).getLongitude();

        //        textView.setText("Latitude: " + String.valueOf(destinolat)
        //                + " | " + "Longitude: " + String.valueOf(destinolong));
        //    }

        //} catch (IOException e) {
        //    e.printStackTrace();
        //}




    }



}