package com.musicoariel4.listasmascotas.fragments;

import android.content.Context;
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
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater2;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.presentador.IRecyclerViewFragmentPresenter2;
import com.musicoariel4.listasmascotas.presentador.RecyclerViewFragmentPresenter2;

import java.util.ArrayList;


public class FragmentAdicional extends Fragment implements IFragmentAdicionalView{

    ArrayList<Mascota> contactos;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter2 presenter2;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_adicional, container, false);
        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas2);

        presenter2 = new RecyclerViewFragmentPresenter2(this,getContext());
                return v;
    }





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
    public void generarLinearLayoutgrill() {

    }

    @Override
    public ContactoAdapater2 crearApaptador(ArrayList<Mascota> contactos) {
        ContactoAdapater2 adaptador2 = new ContactoAdapater2(contactos, (AppCompatActivity) getActivity());
        return adaptador2;
    }

    @Override
    public void inicializadorAdaptador(ContactoAdapater2 adaptador2) {
        listaMascotas.setAdapter(adaptador2);
    }
}