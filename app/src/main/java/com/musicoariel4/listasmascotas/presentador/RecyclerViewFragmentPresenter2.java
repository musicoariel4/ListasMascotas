package com.musicoariel4.listasmascotas.presentador;

import android.content.Context;

import com.musicoariel4.listasmascotas.fragments.IFragmentAdicionalView;
import com.musicoariel4.listasmascotas.fragments.IRecyclerViewFragmentView;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter2 implements IRecyclerViewFragmentPresenter2 {


    private IFragmentAdicionalView iFragmentAdicionalView  ;
    private Context context;
    private ConstructorContactos construtorContactos;
    private ArrayList<Mascota> contactos;

    public RecyclerViewFragmentPresenter2(IFragmentAdicionalView iFragmentAdicionalView, Context context) {
        this.iFragmentAdicionalView = iFragmentAdicionalView;
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
        iFragmentAdicionalView.inicializadorAdaptador(iFragmentAdicionalView.crearApaptador(contactos));
        iFragmentAdicionalView.generarLinearLayoutgrill();
    }
}
