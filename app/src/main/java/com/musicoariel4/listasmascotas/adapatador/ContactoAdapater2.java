package com.musicoariel4.listasmascotas.adapatador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.musicoariel4.listasmascotas.Detalle_Mascota;
import com.musicoariel4.listasmascotas.R;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ContactoAdapater2 extends RecyclerView.Adapter<ContactoAdapater2.ContactoViewHolder> {

    @NonNull
    @Override
    public ContactoAdapater2.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapater2.ContactoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

