package com.jmdevs.petagram.fragments;

import android.content.Context;
import android.view.View;

import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.adapter.mascotaBioAdapter;
import com.jmdevs.petagram.pojo.mascota;
import java.util.ArrayList;

public interface IPet_ProfileView {

    public void generarGridVertical();
    public mascotaBioAdapter crearMProfAdapter(mascota m, Context x);
    public void inicializarPorfAdaptadorRV(mascotaBioAdapter mAdapt);
}
