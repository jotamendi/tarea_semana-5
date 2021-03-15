package com.jmdevs.petagram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.db.BaseDatos;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class mascotaAdapter extends RecyclerView.Adapter<mascotaAdapter.mascotaViewHolder> {

    private Context context;
    ArrayList<mascota> mascotas;
    ArrayList<post> mPosts;

    public  mascotaAdapter(ArrayList<mascota> mascotas, Context c){
        this.mascotas = mascotas;
        /*this.mPosts = posts*/
        context = c;
    }

    @NonNull
    @Override
    //inflar el layout y paras al viewholder para que obtenga los views
    public mascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas, parent, false);
        return new mascotaViewHolder(v);
    }

    @Override
    //asocia c/elem de la lista con c/view
    public void onBindViewHolder(@NonNull mascotaViewHolder holder, int position) {
        mascota mascot = mascotas.get(position);
        ArrayList<post> pts = mascot.getPosts();

        if(!pts.isEmpty()) {
            post p = pts.get(pts.size()-1);
            holder.nameTxt.setText(String.valueOf(mascot.getNombre()));
            holder.rateTxt.setText(String.valueOf(p.getRate()));
            holder.dogPic.setImageResource(p.getPic());
        }

        holder.boneRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.boneRate.getVisibility() == View.VISIBLE){
                    post p = pts.get(pts.size() - 1);
                    mascot.incRate(p.getPost_id(), context);
                    holder.rateTxt.setText(String.valueOf(mascot.getRate(p.getPost_id(),context).toString()));
                    holder.boneRate.setVisibility(view.INVISIBLE);
                    holder.boneUnrate.setVisibility(view.VISIBLE);
                    BaseDatos bd = new BaseDatos(context);
                    bd.addPostToLast5Fav(p.getPost_id(), p.getId_pet());
                }
            }
        });

        holder.boneUnrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.boneUnrate.getVisibility() == view.VISIBLE){
                    ArrayList<post> pts = mascot.getPosts();
                    post p = pts.get(pts.size() - 1);
                    mascot.decRate(p.getPost_id(), context);
                    holder.rateTxt.setText(String.valueOf(mascot.getRate(p.getPost_id(),context).toString()));
                    holder.boneRate.setVisibility(view.VISIBLE);
                    holder.boneUnrate.setVisibility(view.INVISIBLE);
                    BaseDatos bd = new BaseDatos(context);
                    bd.undoPostLikeToLast5Fav(p.getPost_id(), p.getId_pet());
                }
            }
        });

    }

    @Override
    //cant de elems que tiene mi lista de mascotas
    public int getItemCount() {
        /*mPosts.size()*/
        return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView dogPic;
        private TextView nameTxt;
        private TextView rateTxt;
        private ImageButton boneRate;
        private ImageButton boneUnrate;

            public mascotaViewHolder(@NonNull View itemView) {
            super(itemView);
                dogPic      = (ImageView) itemView.findViewById(R.id.img_mascota);
                nameTxt     = (TextView) itemView.findViewById(R.id.dogName);
                rateTxt     = (TextView) itemView.findViewById(R.id.dogRate);
                boneRate    = (ImageButton) itemView.findViewById(R.id.wBone);
                boneUnrate  = (ImageButton) itemView.findViewById(R.id.colorBone);
        }
    }



}
