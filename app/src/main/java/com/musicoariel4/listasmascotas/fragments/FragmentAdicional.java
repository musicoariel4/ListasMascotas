package com.musicoariel4.listasmascotas.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicoariel4.listasmascotas.R;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater2;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;


public class FragmentAdicional extends Fragment {

    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;

    public FragmentAdicional() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_adicional, container, false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas2);

       GridLayoutManager llm = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicilizarAdaptador();
        return v;
    }
    public void inicilizarAdaptador(){
        ContactoAdapater2 adaptador = new ContactoAdapater2(contactos, (AppCompatActivity) getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarlistaMascotas(){

        contactos = new ArrayList<Mascota>();
        contactos.add(new Mascota(R.drawable.akita,"akita","5"));
        contactos.add(new Mascota(R.drawable.chih,"chin","2"));
        contactos.add(new Mascota(R.drawable.gosque,"gosque","2"));
        contactos.add(new Mascota(R.drawable.beagle,"beagle","3"));
        contactos.add(new Mascota(R.drawable.pug,"pug","1"));
    }

}