package com.jmdevs.petagram.fragments;

import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.pojo.mascota;

import java.util.ArrayList;

public interface IPet_FeedFragView {

    public void generarLinearLayoutVertical();
    public mascotaAdapter crearMAdapter(ArrayList<mascota> mascotas);
    public void inicializarAdaptadorRV(mascotaAdapter mAdapt);


}
