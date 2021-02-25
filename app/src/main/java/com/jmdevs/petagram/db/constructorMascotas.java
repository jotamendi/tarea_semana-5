 package com.jmdevs.petagram.db;
import android.content.Context;
import com.jmdevs.petagram.R;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class constructorMascotas {

    private Context context;

    public constructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<mascota> obtenerMascotas(){
        ArrayList<mascota> mascotas = new ArrayList<mascota>();
        mascotas.add(new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier));
        mascotas.add(new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro));
        mascotas.add(new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro));
        mascotas.add(new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro));
        mascotas.add(new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever));

        return mascotas;

    }

    public mascota obtenerMascota(int pos){
        ArrayList<mascota> mascotas = new ArrayList<mascota>();
        mascota m1 = new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier);
        m1.addPosts(new post(m1.getId_pet(),2,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),6,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),4,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),30,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),12,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        mascotas.add(m1);

        mascota m2 = new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro);
        m2.addPosts(new post(m2.getId_pet(),4,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),3,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),9,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),6,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),11,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),20,m2.getPic()));
        mascotas.add(m2);

        mascota m3 =new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro);
        m2.addPosts(new post(m3.getId_pet(),2,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),4,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),8,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),5,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),12,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),25,m3.getPic()));
        mascotas.add(m3);

        mascota m4 = new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro);
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),2,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),10,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),8,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),21,m4.getPic()));
        mascotas.add(m4);

        mascota m5 =new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever);
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),10,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),8,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),7,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),19,m5.getPic()));
        mascotas.add(m5);

        if(pos < 4){
            return mascotas.get(pos);
        }
        else
            return null;
    }

    public ArrayList<post> obtenerMascotaPosts(int pos){
        ArrayList<mascota> mascotas = new ArrayList<mascota>();
        mascota m1 = new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier);
        m1.addPosts(new post(m1.getId_pet(),2,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),6,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),4,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),30,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),12,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        mascotas.add(m1);

        mascota m2 = new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro);
        m2.addPosts(new post(m2.getId_pet(),4,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),3,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),9,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),6,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),11,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),20,m2.getPic()));
        mascotas.add(m2);

        mascota m3 =new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro);
        m2.addPosts(new post(m3.getId_pet(),2,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),4,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),8,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),5,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),12,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),25,m3.getPic()));
        mascotas.add(m3);

        mascota m4 = new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro);
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),2,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),10,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),8,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),21,m4.getPic()));
        mascotas.add(m4);

        mascota m5 =new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever);
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),10,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),8,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),7,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),19,m5.getPic()));
        mascotas.add(m5);

        return mascotas.get(pos).getPosts();
    }


}
