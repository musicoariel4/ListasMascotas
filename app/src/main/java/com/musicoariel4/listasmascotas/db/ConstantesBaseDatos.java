package com.musicoariel4.listasmascotas.db;

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS           = "mascota";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "nombre";
    public static final String TABLE_CONTACTS_FOTO      = "foto";

    public static final String TABLE_LIKES_CONTACT = "mascotas_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_mascota";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
