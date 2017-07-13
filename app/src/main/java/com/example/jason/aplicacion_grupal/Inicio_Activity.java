package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button i_s;
    private Button reg;
    private Button i_l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_);
        i_s = (Button) findViewById(R.id.iniciar_sesion);
        reg = (Button) findViewById(R.id.registrar);
        i_l = (Button) findViewById(R.id.Ing_libre);
        i_s.setOnClickListener(this);
        reg.setOnClickListener(this);
        i_l.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent_libre  = new Intent(getApplicationContext(),ForosActivity.class);

        switch(view.getId()){
            case R.id.iniciar_sesion :
                Intent login = new Intent(getApplicationContext(),Login.class);
                startActivity(login);
                break;
            case R.id.registrar :
                Intent register = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.Ing_libre :
                startActivity(intent_libre);
                break;
        }
    }
}
