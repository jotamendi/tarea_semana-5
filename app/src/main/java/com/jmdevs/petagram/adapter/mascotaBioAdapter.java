package com.jmdevs.petagram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;
import java.util.ArrayList;

public class mascotaBioAdapter extends RecyclerView.Adapter<mascotaBioAdapter.mascotaBioViewHolder> {

    private ArrayList<mascota> mascotas;
    private ArrayList<post> posts;
    private Context context;


    public mascotaBioAdapter(ArrayList<post> posts1, Context c){
        posts = posts1;
        context = c;
    }

    @NonNull
    @Override
    public mascotaBioAdapter.mascotaBioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bio_card_view_mascotas, parent, false);
        /*TextView petName = (TextView) v.findViewById(R.id.pet_name);*/
        return new mascotaBioAdapter.mascotaBioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mascotaBioAdapter.mascotaBioViewHolder holder, int position) {
        post publicacion = posts.get(position);
        holder.rateTxt.setText(String.valueOf(publicacion.getRate()));
        holder.petPic.setImageResource(publicacion.getPic());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class mascotaBioViewHolder extends RecyclerView.ViewHolder {

        private ImageView petPic;
        private TextView rateTxt;

        public mascotaBioViewHolder(@NonNull View itemView) {
            super(itemView);
            petPic      = (ImageView) itemView.findViewById(R.id.img_pet);
            rateTxt     = (TextView) itemView.findViewById(R.id.postRate);
        }


    }

}
