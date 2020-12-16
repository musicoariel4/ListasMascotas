package com.musicoariel4.listasmascotas.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicoariel4.listasmascotas.R;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater;
import com.musicoariel4.listasmascotas.adapatador.ContactoAdapater2;
import com.musicoariel4.listasmascotas.pojo.ConstructorContactos;
import com.musicoariel4.listasmascotas.pojo.Mascota;
import com.musicoariel4.listasmascotas.presentador.IRecyclerViewFragmentPresenter;
import com.musicoariel4.listasmascotas.presentador.IRecyclerViewFragmentPresenter2;
import com.musicoariel4.listasmascotas.presentador.RecyclerViewFragmentPresenter;
import com.musicoariel4.listasmascotas.presentador.RecyclerViewFragmentPresenter2;

import java.util.ArrayList;


public class FragmentAdicional extends Fragment implements IFragmentAdicionalView{



    public FragmentAdicional() {
        // Required empty public constructor
    }



}