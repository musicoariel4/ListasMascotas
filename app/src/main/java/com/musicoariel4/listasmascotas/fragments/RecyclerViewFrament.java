package com.musicoariel4.listasmascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.musicoariel4.listasmascotas.R;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFrament extends Fragment {

    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
     // GridLayoutManager llm = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicilizarAdaptador();
        return v;
    }
    public void inicilizarAdaptador(){
        ContactoAdapater adaptador = new ContactoAdapater(contactos, (AppCompatActivity) getActivity());
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
}