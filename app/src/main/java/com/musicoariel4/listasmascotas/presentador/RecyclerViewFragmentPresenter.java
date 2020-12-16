package com.musicoariel4.listasmascotas.presentador;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.musicoariel4.listasmascotas.fragments.IRecyclerViewFragmentView;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.restApi.IEndpointsApi;
import com.musicoariel4.listasmascotas.restApi.adapter.RestApiAdapter;
import com.musicoariel4.listasmascotas.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView ;
    private Context context;
    private ConstructorContactos construtorContactos;
    private ArrayList<Mascota> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //ObtenerContactosBD();
        obtenerMediosRecientes();
    }

    @Override
  public void ObtenerContactosBD() {
        construtorContactos= new ConstructorContactos(context);
    // contactos=construtorContactos.obtenerDatos();
       mostraContactosRV();

    }


    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();// se comunica con las api de instagram y genera una consulta en formato de json
        Gson gsonMediaRecent = restApiAdapter.contstruyeGsonDeserializadorMediaRecent();//forma de como se desarializa los datos
        IEndpointsApi endpointsApi= restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent); //ejecuta la llamada al servidor
        //ejecuta la llamda get la direcccion
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) { //si trae datos en json
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();//obtengo un arreglo de contactos
                mostraContactosRV();///muestra contactos
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) { //si no trae datos
                Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                Log.e("Connection failed", t.toString());
            }
        });
    }

    @Override
    public void mostraContactosRV() {
        iRecyclerViewFragmentView.inicializadorAdaptador(iRecyclerViewFragmentView.crearApaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayaout();
    }
}
