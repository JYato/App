package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CursosporsemestreActivity extends AppCompatActivity {
    /**
     * Se va a agregar varios string con los cursos de cada carrera por semestre, en total serian 10(semestres) x 9(carreras) = 90 strings; Estos pueden ser extraidos de un xml que contenga cada array
     */
    ListView lista;
    String [] cursos1 = new String[]{"Algebra Abstracta", "Desarrollo Basado en plataformas","Càlculo I", "Ciencia de la Computaciòn II", "Antropologìa", "Arquitectura de Computadoras"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursosporsemestre);
        lista = (ListView) findViewById(R.id.cursossemestrales);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,cursos1);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mint;
                switch(i){
                    case 0 :
                        mint = new Intent(getApplicationContext(),Alg_AbsActivity.class);
                        startActivity(mint);
                        break;
                    case 1 :
                        break;
                    case 2 :
                        break;

                }

            }
        });
    }
}
