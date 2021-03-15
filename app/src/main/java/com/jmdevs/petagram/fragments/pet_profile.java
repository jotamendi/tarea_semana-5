package com.jmdevs.petagram.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.adapter.mascotaBioAdapter;
import com.jmdevs.petagram.db.BaseDatos;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;
import com.jmdevs.petagram.presentador.IPet_FeedFragPresenter;
import com.jmdevs.petagram.presentador.IPet_ProfFragPresenter;
import com.jmdevs.petagram.presentador.Pet_FeedFragPresenter;
import com.jmdevs.petagram.presentador.Pet_ProfFragPresenter;

import java.util.ArrayList;

public class pet_profile extends Fragment implements IPet_ProfileView{

    private RecyclerView listaPosts;
    private ArrayList<mascota> mascotas;
    private ArrayList<post> posts;
    private ImageView circProfPic;
    private TextView petName;
    private IPet_ProfFragPresenter PPPresenter;

    public pet_profile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pet_profile, container, false);
        setProfile(v);
        listaPosts = (RecyclerView) v.findViewById(R.id.rv_bio_mascota);
        PPPresenter = new Pet_ProfFragPresenter(this, getContext());
        return v;
    }

   public void setProfile(View v) {
        petName = (TextView) v.findViewById(R.id.pet_name);
        circProfPic = (ImageView) v.findViewById(R.id.circular_prof_pic);
    }

    @Override
    public void generarGridVertical() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaPosts.setLayoutManager(glm);
    }

    @Override
    public mascotaBioAdapter crearMProfAdapter(mascota m1, Context c) {
        petName.setText(m1.getNombre());
        circProfPic.setImageResource(m1.getPic());
        BaseDatos bd = new BaseDatos(c);
        mascotaBioAdapter mBAdapt = new mascotaBioAdapter(bd.getMascotaPosts(m1.getId_pet()), getActivity());
        return mBAdapt;
    }

    @Override
    public void inicializarPorfAdaptadorRV(mascotaBioAdapter mBAdapt) {
        listaPosts.setAdapter(mBAdapt);
    }


}