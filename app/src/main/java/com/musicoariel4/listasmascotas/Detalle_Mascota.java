package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class Detalle_Mascota extends AppCompatActivity {
    private static final String KEY_EXTRA_URL="url";
    private static final String KEY_EXTRA_LIKES="number";
    // private TextView tvNombre;
    // private TextView tvEmail;
    // private TextView tvTelefono;
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);

        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //   ActionBar ab = getSupportActionBar();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString(KEY_EXTRA_URL);
        int likes =bundle.getInt(KEY_EXTRA_LIKES);


        imgFotoDetalle =(ImageView)findViewById(R.id.imgFotoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.akita)
                .into(imgFotoDetalle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(500);


            getWindow().setEnterTransition(slide);

            getWindow().setReturnTransition(new Fade());
        } else {

        }
        tvLikesDetalles =(TextView)findViewById(R.id.tvLikesDetalles);
        tvLikesDetalles.setText(String.valueOf(likes));

        //  tvDetailLikes = findViewById(R.id.tvDetailLikes);
        // tvDetailLikes.setText(String.valueOf(likes));
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent2 = new Intent(this,MainActivity.class);
            startActivity(intent2);
        }
        return super.onKeyDown(keyCode,event);
    }

}
