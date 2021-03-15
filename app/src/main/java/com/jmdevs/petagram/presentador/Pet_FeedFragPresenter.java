package com.jmdevs.petagram.presentador;

import android.content.Context;

import com.jmdevs.petagram.db.constructorMascotas;
import com.jmdevs.petagram.fragments.IPet_FeedFragView;
import com.jmdevs.petagram.fragments.IPet_ProfileView;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pet_FeedFragPresenter implements  IPet_FeedFragPresenter{

    private IPet_FeedFragView iPet_FeedFragView;
    private constructorMascotas cM;
    private Context context;
    private ArrayList<mascota> mascotas;
    private ArrayList<post> posts;

    public Pet_FeedFragPresenter(IPet_FeedFragView iPet_feedFragView, Context context){
        this.iPet_FeedFragView = iPet_feedFragView;
        this.context = context;
        /*ObtenerMascotasBD();*/
        obtenerAllPosts();
    }

    @Override
    public void ObtenerMascotasBD() {
        cM = new constructorMascotas(context);
        mascotas =  cM.obtenerMascotas();
        mostrarMascotasRV();
    }

    public void obtenerAllPosts(){
        cM = new constructorMascotas(context);
        posts = cM.getAllPosts();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iPet_FeedFragView.inicializarAdaptadorRV(iPet_FeedFragView.crearMAdapter(posts));
        iPet_FeedFragView.generarLinearLayoutVertical();
    }

}
