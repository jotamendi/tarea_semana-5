package com.jmdevs.petagram.fragments;

import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.adapter.mascotaPostsAdapter;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public interface IPet_FeedFragView {

    public void generarLinearLayoutVertical();
    public mascotaPostsAdapter crearMAdapter(ArrayList<post> posts);
    public void inicializarAdaptadorRV(mascotaPostsAdapter mPAdapt);


}
