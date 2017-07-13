package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UniversidadesActivity extends AppCompatActivity {
    ListView lista;
    String [] universidades = new String[]{"@string/UCSP","@string/UNSA","@string/UCSM","@string/UTP","@string/Salle"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidades);
        lista = (ListView) findViewById(R.id.universidades);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,universidades);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mint;
                switch(i){
                    case 0 :
                        mint = new Intent(getApplicationContext(),CarrerasUcspActivity.class);
                        startActivity(mint);
                        break;
                    case 1:
                        mint = new Intent(getApplicationContext(),CarrerasUcspActivity.class);
                        startActivity(mint);
                        break;
                    case 2 :
                        mint = new Intent(getApplicationContext(),CarrerasUcspActivity.class);
                        startActivity(mint);
                        break;
                    case 3 :
                        mint = new Intent(getApplicationContext(),CarrerasUcspActivity.class);
                        startActivity(mint);
                        break;
                    case 4 :
                        mint = new Intent(getApplicationContext(),CarrerasUcspActivity.class);
                        startActivity(mint);
                        break;
                }
            }
        });
    }
}
