 package com.jmdevs.petagram.db;
import android.content.ContentValues;
import android.content.Context;
import com.jmdevs.petagram.R;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

import javax.crypto.BadPaddingException;

 public class constructorMascotas {

    private Context context;

    public constructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<mascota> obtenerMascotas(){
        BaseDatos bd = new BaseDatos(context);
        if(bd.isEmpty())
            insertMascotas(bd);
        return bd.obtenerAllMascotas();

    }

    public ArrayList<post> getAllPosts(){
        BaseDatos bd = new BaseDatos(context);
        if(bd.isEmpty())
            insertMascotas(bd);
        return bd.getAllPosts();
    }

    public mascota obtenerMascota(int pos){
        BaseDatos bd = new BaseDatos(context);
        if(bd.isEmpty())
            insertMascotas(bd);
        if(pos < 4){
            return bd.obtenerMascota(pos);
        }
        else
            return null;
    }

    public void insertMascotas(BaseDatos bd){
        ContentValues cv = new ContentValues();
        ContentValues cv2 = new ContentValues();
        /*mascota m1 = new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier);*/
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Rocky");
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.bull_terrier);
        bd.insertMascota(cv);
       /* cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,0);*/
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,1);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST, R.drawable.bull_terrier);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,1);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST, R.drawable.bull_terrier);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,1);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST, R.drawable.bull_terrier);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,1);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);

        /*mascota m2 = new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro);*/
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Bobby");
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pitbull_cachorro);
        bd.insertMascota(cv);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,2);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST,R.drawable.pitbull_cachorro);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);

        /* mascota m3 =new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro);*/
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Rudolph");
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.doberman_cachorro);
        bd.insertMascota(cv);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,3);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST,R.drawable.doberman_cachorro);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);

        /* mascota m4 = new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro);*/
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Scott");
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.rottweiler_cachorro);
        bd.insertMascota(cv);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,4);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST, R.drawable.rottweiler_cachorro);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);

        /*mascota m5 =new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever);*/
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Lucky");
        cv.put(constantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.golden_retriever);
        bd.insertMascota(cv);
        cv2.put(constantesBaseDatos.TABLE_POSTS_ID_MASCOTA,5);
        cv2.put(constantesBaseDatos.TABLE_POSTS_POST, R.drawable.golden_retriever);
        cv2.put(constantesBaseDatos.TABLE_POSTS_RATE,0);
        cv2.put(constantesBaseDatos.TABLE_POSTS_LIKED, 0);
        bd.insertMascotaPost(cv2);
    }

}
