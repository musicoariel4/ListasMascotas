package com.musicoariel4.listasmascotas.presentador;


import android.content.Context;

import com.musicoariel4.listasmascotas.fragments.IRecyclerViewFragmentView;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView ;
    private Context context;
    private ConstructorContactos construtorContactos;
    private ArrayList<Mascota> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        ObtenerContactosBD();
    }

    @Override
    public void ObtenerContactosBD() {
        construtorContactos= new ConstructorContactos(context);
        contactos=construtorContactos.obtenerDatos();
        mostraContactosRV();

    }

    @Override
    public void mostraContactosRV() {
        iRecyclerViewFragmentView.inicializadorAdaptador(iRecyclerViewFragmentView.crearApaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
