package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

public class Formulario extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1; // código de solicitud
    private TextInputEditText tvNombre;
    private TextInputEditText tvEmail;
    private TextInputEditText tvTelefono;
    private TextInputEditText tvDescripcion;
    private Button miboton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        tvNombre = (TextInputEditText) findViewById(R.id.tvNombre);
        tvEmail = (TextInputEditText) findViewById(R.id.tvEmail);
        tvTelefono = (TextInputEditText) findViewById(R.id.tvTelefono);
        tvDescripcion = (TextInputEditText) findViewById(R.id.tvDescripcion);
        miboton1 = (Button) findViewById(R.id.miboton1);

        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //   ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void siguiente(View view) {

        String eNombre = tvNombre.getText().toString();
        String eEmail = tvEmail.getText().toString();
        String eTelefono = tvTelefono.getText().toString();
        String eDescripcion = tvDescripcion.getText().toString();
        Intent emailIntent =new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,eNombre);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,eTelefono);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, eDescripcion);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,eEmail);
        emailIntent.setType(("messge/rfc822"));
        startActivity(Intent.createChooser(emailIntent,"Email"));

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