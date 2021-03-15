package com.jmdevs.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.adapter.mascotaPostsAdapter;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;
import com.jmdevs.petagram.presentador.IPet_FeedFragPresenter;
import com.jmdevs.petagram.presentador.Pet_FeedFragPresenter;

import java.util.ArrayList;


public class pet_feed extends Fragment  implements  IPet_FeedFragView{

    private RecyclerView listaMascotasPosts;
    private ArrayList<mascota> mascotas;
    private IPet_FeedFragPresenter PFPresenter;


    public pet_feed() {
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
        View v =  inflater.inflate(R.layout.fragment_pet_feed, container, false);

        listaMascotasPosts = (RecyclerView) v.findViewById(R.id.rv_mascota);
        PFPresenter = new Pet_FeedFragPresenter(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasPosts.setLayoutManager(llm);
    }


    @Override
    public mascotaPostsAdapter crearMAdapter(ArrayList<post> posts) {
        mascotaPostsAdapter mPAdapt = new mascotaPostsAdapter(posts, getActivity());
        return mPAdapt;
    }

    @Override
    public void inicializarAdaptadorRV(mascotaPostsAdapter mAdapt) {
        listaMascotasPosts.setAdapter(mAdapt);
    }
}