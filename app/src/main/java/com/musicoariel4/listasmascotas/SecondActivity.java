package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
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

        Toolbar miActionBar2 = (Toolbar) findViewById(R.id.miActionBarSecond);
        setSupportActionBar(miActionBar2);




    }

}