package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //  GridLayoutManager llm = new GridLayoutManager(this,2);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicilizarAdaptador();

    }
    public void inicilizarAdaptador(){
        ContactoAdapater adaptador = new ContactoAdapater(contactos,this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarlistaMascotas(){

        contactos = new ArrayList<Mascota>();
        contactos.add(new Mascota(R.drawable.akita,"akita","0"));
        contactos.add(new Mascota(R.drawable.chih,"chin","0"));
        contactos.add(new Mascota(R.drawable.gosque,"gosque","0"));
        contactos.add(new Mascota(R.drawable.beagle,"beagle","0"));
        contactos.add(new Mascota(R.drawable.pug,"pug","0"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}