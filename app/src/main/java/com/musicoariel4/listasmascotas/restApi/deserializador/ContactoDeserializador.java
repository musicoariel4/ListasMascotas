package com.musicoariel4.listasmascotas.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.restApi.JsonKeys;
import com.musicoariel4.listasmascotas.restApi.model.ContactoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {

    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json,ContactoResponse.class);//objecto final con todos los datos contactoResponse
        JsonArray contactoRespondeData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);//lleva los datos del json a variables
        contactoResponse.setContactos(deserializadorContactoDeJson(contactoRespondeData));//recibe un arreglo de contactos

        return contactoResponse;
    }
    private ArrayList<Mascota> deserializadorContactoDeJson(JsonArray contactoRespondeData){
        ArrayList<Mascota> contactos = new ArrayList<>();
        for (int i = 0;i<contactoRespondeData.size(); i++){
            JsonObject contactoResponseDataObject = contactoRespondeData.get(i).getAsJsonObject();//obtiene el {} 0
            String id  = contactoResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto  = contactoResponseDataObject.get(JsonKeys.USER_USER_NAME).getAsString();
            String urlFoto  = contactoResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes= contactoResponseDataObject.get(JsonKeys.MEDIA_LIKES).getAsInt();

            Mascota contactoActual = new Mascota();
            contactoActual.setId(id);
            contactoActual.setNombreCompleto(nombreCompleto);
            contactoActual.setUrlFoto(urlFoto);
            contactoActual.setLikes(likes);

            contactos.add(contactoActual);
        }
        return contactos;
    }
}
