package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FotosNTLActivity extends AppCompatActivity {
    Button vermap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos_ntl);
        vermap = (Button) findViewById(R.id.ver_mapas);
        vermap.setOnClickListener(new View.OnClickListener()
                                  {

                                      @Override
                                      public void onClick(View view) {
                                          Intent mint = new Intent(getApplicationContext(),MapsActivity.class);
                                          startActivity(mint);
                                      }
                                  }
        );
    }
}
