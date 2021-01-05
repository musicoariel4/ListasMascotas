package com.musicoariel4.listasmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.adapatador.PagerAdapter;
import com.musicoariel4.listasmascotas.fragments.FragmentAdicional;
import com.musicoariel4.listasmascotas.fragments.RecyclerViewFrament;
import com.musicoariel4.listasmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =(Toolbar) findViewById(R.id.miActionBar);
        TabLayout tabLayout =(TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        FloatingActionButton fab = findViewById(R.id.fab);

        //*****validacion del toolbar
        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),agregarFragments());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.huesoblanco);

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFrament());
        fragments.add(new FragmentAdicional());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_favorite:
                Intent intentf = new Intent(this, SecondActivity.class);
                startActivity(intentf);
                return true;

            case R.id.action_settings:
                Intent intcontacto =new  Intent(this,Formulario.class);
               startActivity(intcontacto);
                return true;

            case R.id.action_settings2:
                Intent intBio =new  Intent(this,Biografia.class);
                startActivity(intBio);
                return true;

            case R.id.action_settings3:
                Intent cuentaUsu =new  Intent(this,CuentaUsuario.class);
                startActivity(cuentaUsu);
                return true;
            case R.id.action_settings4:

                Intent noti =new  Intent(this,Notificaciones.class);
                startActivity(noti);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}