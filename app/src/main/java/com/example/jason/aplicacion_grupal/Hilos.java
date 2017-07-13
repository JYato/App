package com.example.jason.aplicacion_grupal;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.jason.aplicacion_grupal.R.id.etCorreo;
import static com.example.jason.aplicacion_grupal.R.id.etNhilo;
import static com.example.jason.aplicacion_grupal.R.id.etUsuario;

public class Hilos extends AppCompatActivity {
    Button crear;
    EditText Nhilo;
    ListView listaResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilos);
        crear = (Button) findViewById(R.id.crearhilo);
        Nhilo = (EditText) findViewById(R.id.etNhilo);
        listaResultado = (ListView)findViewById(R.id.listahilos);
        Intent intent = getIntent();
        Bundle helps = intent.getExtras();
        int id_forum = 0;
        String nombre ="";
        if(helps != null){
            id_forum = helps.getInt("id_forum");
            nombre = helps.getString("nombre");
        }
        final String id_usertemp = "httpp://10.0.2.2/Trabajogrupal/consultaridusuario.php?nombre="+nombre;
        String temp = Obtener(id_usertemp);
        final int id_user = Integer.parseInt(temp);
        ///String id_forum = "httpp://10.0.2.2/Trabajogrupal/consultaridforum.php";
        final int finalId_forum = id_forum;
        crear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String time = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
                new CargarDatos().execute("http://10.0.2.2/Trabajogrupal/registerhilo.php?id_forum="+finalId_forum+"&id_usuario="+id_user+"&titulo="+Nhilo.getText().toString()+"&fecha="+time);
                Intent refresh = new Intent(getApplicationContext(),Hilos.class);
                startActivity(refresh);
                finish();

            }
        });
        String consulta = "http://10.0.2.2/Trabajogrupal/consultarhilo.php?id_forum="+id_forum;
        EnviarRecibirDatos(consulta);
    }

    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            /*Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),ForosActivity.class);
            startActivity(intent);*/
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;

        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            String contentAsString = readIt(is, len);
            return contentAsString;

        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    public void EnviarRecibirDatos(String URL){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        //Log.i("sizejson",""+ja.length());
                        CargarListView(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }

    public void CargarListView(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=1){

            try {

                lista.add(ja.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaResultado.setAdapter(adaptador);

    }

    private String Obtener(String URL) {

        Log.i("url", "" + URL);
        final String[] user = {" "};
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray js = new JSONArray(response);
                    user[0] = js.getString(0);
                   /* if (contra.equals(etContra.getText().toString())) {

                        //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "verifique su contraseña", Toast.LENGTH_SHORT).show();

                    }*/

                } catch (JSONException e) {
                    e.printStackTrace();

                    //Toast.makeText(getApplicationContext(), "El usuario no existe en la base de datos", Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);


        return user[0];
    }
}
