package com.musicoariel4.listasmascotas.fragments;


import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater2;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IFragmentAdicionalView {


    public void generarGridLayaout(); // implemta forma de grilla
    public void generarLinearLayoutgrill(); //
    public ContactoAdapater2 crearApaptador(ArrayList<Mascota> contactos);
    public  void  inicializadorAdaptador(ContactoAdapater2 adaptador);

}
