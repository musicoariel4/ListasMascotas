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
    ArrayList<Mascota> contactos;
    AppCompatActivity activity;

    public ContactoAdapater2(ArrayList<Mascota> contactos, AppCompatActivity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }


    @Override
    public ContactoAdapater2.ContactoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascotas2,parent,false);
        return new ContactoAdapater2.ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ContactoAdapater2.ContactoViewHolder holder, int position) {
        final Mascota contacto =contactos.get(position);


        Picasso.with(activity)
                .load(contacto.getUrlFoto())
                .placeholder(R.drawable.akita)
                .into(holder.imgFoto);

        holder.tvLikes.setText(String.valueOf(contacto.getLikes())+ " " );



        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, Detalle_Mascota.class);
                intent.putExtra("url",contacto.getUrlFoto());
                intent.putExtra("like",contacto.getLikes());

                activity.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() { ///numero de cobtactos en la lista
        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvLikes;

        public ContactoViewHolder (View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);
        }}
}

