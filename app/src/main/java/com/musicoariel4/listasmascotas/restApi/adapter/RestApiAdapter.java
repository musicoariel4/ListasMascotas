package com.musicoariel4.listasmascotas.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.musicoariel4.listasmascotas.restApi.ConstantesRestApi;
import com.musicoariel4.listasmascotas.restApi.IEndpointsApi;
import com.musicoariel4.listasmascotas.restApi.deserializador.ContactoDeserializador;
import com.musicoariel4.listasmascotas.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public IEndpointsApi establecerConexionRestApiInstagram(Gson gson){//desariliza en forma especifica
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))//gson desarezaliza
                .build();
        IEndpointsApi r =retrofit.create(IEndpointsApi.class);
        return r;
    }
    public Gson contstruyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();//asocia el json contactorespond
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }
    public IEndpointsApi  establecerConexionRestAPI(){
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_SERVE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(IEndpointsApi.class);

    }

}
