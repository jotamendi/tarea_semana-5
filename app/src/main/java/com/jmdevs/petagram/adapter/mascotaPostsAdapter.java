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

public class mascotaPostsAdapter extends RecyclerView.Adapter<mascotaPostsAdapter.mascotaPostsViewHolder> {

    private ArrayList<post> posts;
    private Context context;

    public mascotaPostsAdapter(ArrayList<post> mposts, Context c){
        posts = mposts;
        context = c;
    }


    @NonNull
    @Override
    public mascotaPostsAdapter.mascotaPostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas, parent, false);
        return new mascotaPostsAdapter.mascotaPostsViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull mascotaPostsAdapter.mascotaPostsViewHolder holder, int position) {
        post p = posts.get(position);
        BaseDatos BD = new BaseDatos(context);
        String petName = BD.getPetName(p.getId_pet());
        holder.nameTxt.setText(String.valueOf(petName));
        holder.rateTxt.setText(String.valueOf(p.getRate()));
        holder.petPic.setImageResource(p.getPic());


        if(p.getLiked() == 0) {
            holder.boneRate.setVisibility(View.VISIBLE);
            holder.boneUnrate.setVisibility(View.INVISIBLE);
        }
        else{
            holder.boneRate.setVisibility(View.INVISIBLE);
            holder.boneUnrate.setVisibility(View.VISIBLE);
        }

        holder.boneRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.boneRate.getVisibility() == View.VISIBLE){
                    BD.ratePost(p.getPost_id(), p.getId_pet());
                    holder.rateTxt.setText(String.valueOf(BD.getPostRate(p.getPost_id(),p.getId_pet())).toString());
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
                    BD.unratePost(p.getPost_id(), p.getId_pet());
                    holder.rateTxt.setText(String.valueOf(BD.getPostRate(p.getPost_id(),p.getId_pet())).toString());
                    holder.boneRate.setVisibility(view.VISIBLE);
                    holder.boneUnrate.setVisibility(view.INVISIBLE);
                    BaseDatos bd = new BaseDatos(context);
                    bd.undoPostLikeToLast5Fav(p.getPost_id(), p.getId_pet());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class mascotaPostsViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTxt;
        private ImageView petPic;
        private TextView rateTxt;
        private ImageButton boneRate;
        private ImageButton boneUnrate;

        public mascotaPostsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt         = (TextView) itemView.findViewById(R.id.dogName);
            petPic          = (ImageView) itemView.findViewById(R.id.img_mascota);
            rateTxt         = (TextView) itemView.findViewById(R.id.dogRate);
            boneRate        = (ImageButton) itemView.findViewById(R.id.wBone);
            boneUnrate      = (ImageButton) itemView.findViewById(R.id.colorBone);
        }


    }

}
