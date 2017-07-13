package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Alg_AbsActivity extends AppCompatActivity {
    ListView lista;
    String [] temas = new String[] {"#Fotos#NTL#ABRIL#GENERADOR","#FOTOS#SABADO#MAYO#20", "#FOTOS#SABADO#JUNIO#10"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alg__abs);
        lista = (ListView) findViewById(R.id.listalgebra);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,temas);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mint;
                switch(i){
                    case 0 :
                        mint = new Intent(getApplicationContext(),FotosNTLActivity.class);
                        startActivity(mint);
                }
            }
        });
    }
}
