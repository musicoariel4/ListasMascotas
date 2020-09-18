package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class Detalle_Mascota extends AppCompatActivity {

    private ImageView foto;
    private TextView tvNombre;
    private TextView  tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__mascota);

        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //   ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        int datoFoto =bundle.getInt("FotoContacto");
        String datoNombre=bundle.getString("nombreContacto");
        String datoContador=bundle.getString("contadorContacto");

        foto= (ImageView)findViewById(R.id.imgFoto);
        tvNombre = (TextView)findViewById(R.id.tvNombreCV);
        tvContador= (TextView) findViewById(R.id.tvContador);

        foto.setImageResource(datoFoto);
        tvNombre.setText(datoNombre);
        tvContador.setText(datoContador);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent2 = new Intent(this,MainActivity.class);
            startActivity(intent2);
        }
        return super.onKeyDown(keyCode,event);
    }
}