package com.musicoariel4.listasmascotas.pojo;


import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.musicoariel4.listasmascotas.R;
import com.musicoariel4.listasmascotas.db.BaseDatos;
import com.musicoariel4.listasmascotas.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorContactos{
        private static final int LIKE = 1;
        private Context context;
        public ConstructorContactos(Context context) {
            this.context = context;
        }

        public ArrayList<Mascota> obtenerDatos() {
            BaseDatos db = new BaseDatos(context);
            insertarTresContactos(db);
            return  db.obtenerTodosLosContactos();
        }



        public void insertarTresContactos(BaseDatos db){
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "akita");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.akita);
            db.insertarContacto(contentValues);

             contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "chin");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.chih);
            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "gosque");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.gosque);
            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "beagle");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.beagle);
            db.insertarContacto(contentValues);

             contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "pug");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pug);
            db.insertarContacto(contentValues);

        }


        public void darLikeCotnacto(Mascota contacto){
            BaseDatos db = new BaseDatos(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
            db.insertarLikeContacto(contentValues);
        }

        public int obtenerLikesContacto(Mascota contacto){
            BaseDatos db = new BaseDatos(context);
            return db.obtenerLikesContacto(contacto);
        }


}