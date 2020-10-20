package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar miActionBar2 =(Toolbar) findViewById(R.id.miActionBarSecond);
        setSupportActionBar(miActionBar2);

        //   ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        //  GridLayoutManager llm = new GridLayoutManager(this,2);

        listaMascotas.setLayoutManager(llm2);
        inicializarlistaMascotas();
        inicilizarAdaptador();

    }
    public void inicilizarAdaptador(){
        ContactoAdapater adaptador = new ContactoAdapater(contactos,this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarlistaMascotas(){

        contactos = new ArrayList<Mascota>();
        contactos.add(new Mascota(R.drawable.akita,"akita",1));
        contactos.add(new Mascota(R.drawable.chih,"chin",2));
        contactos.add(new Mascota(R.drawable.gosque,"gosque",5));
        contactos.add(new Mascota(R.drawable.beagle,"beagle",4));
        contactos.add(new Mascota(R.drawable.pug,"pug",3));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }




}