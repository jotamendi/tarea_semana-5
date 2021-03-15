package com.jmdevs.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.adapter.mascotaPostsAdapter;
import com.jmdevs.petagram.db.BaseDatos;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class ultimos5Fav extends AppCompatActivity {

    private RecyclerView listaMascotas2;
    ArrayList<mascota> mascotas2;
    ArrayList<post> mPostsLiked;

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
        mascotaPostsAdapter mPAdapt = new mascotaPostsAdapter(mPostsLiked, this);
        listaMascotas2.setAdapter(mPAdapt);
    }

    public void initListaMascotas2(){
        Context c = getBaseContext();
        BaseDatos bd = new BaseDatos(c);
        mPostsLiked = new ArrayList<post>();
        mPostsLiked = bd.getLast5Favs();

    }
}