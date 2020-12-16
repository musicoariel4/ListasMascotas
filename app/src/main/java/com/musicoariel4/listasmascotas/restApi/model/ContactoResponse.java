package com.musicoariel4.listasmascotas.restApi.model;

import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class ContactoResponse {
    ArrayList<Mascota> contactos;

    public ArrayList<Mascota> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Mascota> contactos) {
        this.contactos = contactos;
    }
}


