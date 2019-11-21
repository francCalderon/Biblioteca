package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private ProgressBar pgb;
    private Button btn;
    private int progreso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.edtUsuario);
        et2 = (EditText)findViewById(R.id.edtContraseña);
        btn = (Button)findViewById(R.id.btnLogin);
        pgb = (ProgressBar)findViewById(R.id.pgbProgreso);

        pgb.setVisibility((View.INVISIBLE));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(et1.getText().toString());
            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {

        //Se utiliza para configurar la tarea, por ejemplo
            //mostrando la barra de progreso
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pgb.setVisibility(View.VISIBLE);
        }

        //Procesos complejos o tareas pesadas
        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s){
            Intent i = new Intent(getBaseContext(), HOME_ACT.class);
            startActivity(i);

            pgb.setVisibility(View.INVISIBLE);
        }

    }
}
