package com.jmdevs.petagram.presentador;

import android.content.Context;
import android.view.View;

import com.jmdevs.petagram.db.constructorMascotas;
import com.jmdevs.petagram.fragments.IPet_ProfileView;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class Pet_ProfFragPresenter implements IPet_ProfFragPresenter{
    private IPet_ProfileView iPet_ProfileFragView;
    private mascota mascot;
    private ArrayList<post> posts;
    private Context context;
    private constructorMascotas cM;

    public Pet_ProfFragPresenter( IPet_ProfileView iPet_ProfileFragView, Context context){
        this.iPet_ProfileFragView = iPet_ProfileFragView;
        this.context = context;
        ObtenerMascotaBD();
    }

    @Override
    public void ObtenerMascotaBD() {
        cM = new constructorMascotas(context);
        mascot = cM.obtenerMascota(0);
        mostrarPostsRV();
    }

  /*  @Override
    public void ObtenerMascotaPostsBD() {
        posts = new ArrayList<>();
        posts = cM.obtenerMascotaPosts(0);
    }*/

    @Override
    public void mostrarPostsRV() {
        iPet_ProfileFragView.inicializarPorfAdaptadorRV(iPet_ProfileFragView.crearMProfAdapter(mascot));
        iPet_ProfileFragView.generarGridVertical();
    }
}
