package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CarrerasUcspActivity extends AppCompatActivity {
    ListView lista;
    String [] carreras = new String[]{"Ciencia de la Computación","Ingeniería Civil", "Ingeniería Industrial", "Ing. Elec. y Telec.", "Derecho", "Administración", "Psicología", "Educación"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carreras_ucsp);
        lista = (ListView) findViewById(R.id.CarrerasUcsp);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, carreras);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mint = null;
                switch (i){
                    case 0 :
                        mint = new Intent(getApplicationContext(),SemestreActivity.class);
                        break;
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                }
                mint.putExtra("carrera",carreras[i]);
                startActivity(mint);

            }
        });
    }
}
