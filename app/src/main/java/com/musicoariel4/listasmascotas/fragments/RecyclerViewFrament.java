package com.musicoariel4.listasmascotas.fragments;

import android.content.Context;
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
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.presentador.IRecyclerViewFragmentPresenter;
import com.musicoariel4.listasmascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFrament extends Fragment  implements  IRecyclerViewFragmentView{

    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);
        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        // LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        // llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayaout() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapater crearApaptador(ArrayList<Mascota> contactos) {
        ContactoAdapater adaptador = new ContactoAdapater(contactos, (AppCompatActivity) getActivity());
        return adaptador;
    }

    @Override
    public void inicializadorAdaptador(ContactoAdapater adaptador) {
          listaMascotas.setAdapter(adaptador);
    }
}