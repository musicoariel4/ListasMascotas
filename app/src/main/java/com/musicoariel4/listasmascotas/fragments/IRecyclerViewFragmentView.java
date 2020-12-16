package com.musicoariel4.listasmascotas.fragments;

import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical(); // implemta en forma vertical
    public void generarGridLayaout(); // implemta forma de grilla
    public ContactoAdapater crearApaptador(ArrayList<Mascota> contactos);
    public  void  inicializadorAdaptador(ContactoAdapater adaptador);

}