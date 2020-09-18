package com.musicoariel4.listasmascotas;

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
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoAdapater.ContactoViewHolder holder, int position) {
              final Mascota contacto =contactos.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvContador.setText(contacto.getContador());

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(activity,"Diste Me gusta a "+ contacto.getNombre(),Toast.LENGTH_SHORT).show();
                int numEntero = Integer.parseInt(contacto.getContador());
                numEntero = numEntero +1;
                contacto.setContador( String.valueOf(numEntero));
                Toast.makeText(activity,"Diste Me gusta a "+ contacto.getNombre()+ " n."+ contacto.getContador(),Toast.LENGTH_SHORT).show();

            }
        });

        holder.btnLike2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(activity,"like 2 "+ contacto.getNombre(),Toast.LENGTH_SHORT).show();
              holder.tvContador.setText(contacto.getContador());

            }
        });

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(activity,Detalle_Mascota.class);
                intent.putExtra("FotoContacto",contacto.getFoto());
                intent.putExtra("nombreContacto",contacto.getNombre());
                intent.putExtra("contadorContacto",contacto.getContador());

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
        private TextView tvNombreCV;
        private TextView tvContador;
        private ImageButton btnLike;
        private ImageButton btnLike2;

        public ContactoViewHolder (View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnlike);
            tvNombreCV =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvContador = (TextView)itemView.findViewById(R.id.tvContador);
            btnLike2 = (ImageButton) itemView.findViewById(R.id.btnlike2);



        }

    }
}
