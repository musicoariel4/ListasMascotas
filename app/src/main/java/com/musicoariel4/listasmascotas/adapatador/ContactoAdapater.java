package com.musicoariel4.listasmascotas.adapatador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.musicoariel4.listasmascotas.Detalle_Mascota;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class ContactoAdapater extends RecyclerView.Adapter<ContactoAdapater.ContactoViewHolder> {

    ArrayList<Mascota> contactos;
    AppCompatActivity activity;

    public ContactoAdapater(ArrayList<Mascota> contactos, AppCompatActivity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    //infla el layout y lo pasara al ViewHolder para oobtener los view
    @Override
    public ContactoAdapater.ContactoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascotas,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoAdapater.ContactoViewHolder holder, int position) {
              final Mascota contacto =contactos.get(position);

       // holder.imgFoto.setImageResource(contacto.getFoto());
       // holder.tvNombreCV.setText(contacto.getNombre());
       // holder.tvContador.setText(contacto.getLikes());
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

    public class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;

        public ContactoViewHolder (View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);
        }

    }
}
