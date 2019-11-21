package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HOME_ACT extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__act);

        vf = (ViewFlipper)findViewById(R.id.transicion);

        //ciclo for para recorrer los slider
        for(int i = 0; i < images.length; i++){
            Sliders(images[i]);
        }
    }

    public void Sliders(int i){
        ImageView view = new ImageView(this); //tomo las imagenes del contexto
        view.setBackgroundResource(i); //seteamos el background

        vf. addView(view); // añadimos el viewflipper
        vf.setFlipInterval(5000); // determinamos intervalos por slide
        vf.setAutoStart(true); // comience automaticamente

        // Aquí se declara el sentido de la transición
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
