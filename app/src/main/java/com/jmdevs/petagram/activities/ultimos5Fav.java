package com.jmdevs.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.pojo.mascota;

import java.util.ArrayList;

public class ultimos5Fav extends AppCompatActivity {

    private RecyclerView listaMascotas2;
    ArrayList<mascota> mascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimos5_fav);

        Toolbar actionBar = (Toolbar) findViewById(R.id.action_bar2);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas2 = (RecyclerView) findViewById(R.id.rv_mascota2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(llm);
        initListaMascotas2();
        initAdapter();

    }

    public void initAdapter(){
        mascotaAdapter mAdapt = new mascotaAdapter(mascotas2, this);
        listaMascotas2.setAdapter(mAdapt);
    }

    public void initListaMascotas2(){
        mascotas2 = new ArrayList<mascota>();

        mascota m1 = new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier);
        mascota m2 = new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro);
        mascota m3 = new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro);
        mascota m4 = new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro);
        mascota m5 = new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever);

        m1.incRate();
        m2.incRate();
        m3.incRate();
        m4.incRate();
        m5.incRate();

        mascotas2.add(m5);
        mascotas2.add(m4);
        mascotas2.add(m3);
        mascotas2.add(m2);
        mascotas2.add(m1);

    }
}