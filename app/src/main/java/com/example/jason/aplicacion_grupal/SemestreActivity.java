package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SemestreActivity extends AppCompatActivity {
    ListView lista;
    String [] semestre = new String[]{"Primero", "Segundo","Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semestre);
        lista = (ListView) findViewById(R.id.semestres);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,semestre);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mint;
                switch(i) {
                    case 0 :
                        break;
                    case 1 :
                        break;
                    case 2 :
                        mint = new Intent(getApplicationContext(),CursosporsemestreActivity.class);
                        startActivity(mint);
                        break;
                    case 3 :
                        break;
                }

            }
        });

    }
}
