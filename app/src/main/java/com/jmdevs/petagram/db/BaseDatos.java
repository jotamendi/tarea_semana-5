package com.jmdevs.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    private ArrayList<post> ultimos5Fav;

    public BaseDatos(@Nullable Context context) {
        super(context, constantesBaseDatos.DATABASE_NAME, null, constantesBaseDatos.DATBASE_VERSION);
        this.context = context;
        ultimos5Fav = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + constantesBaseDatos.TABLE_MASCOTAS         + "(" +
                                                        constantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        constantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT," +
                                                        constantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER" + ")";


        String queryCrearTablaPosts = "CREATE TABLE " + constantesBaseDatos.TABLE_POSTS             + "(" +
                                                        constantesBaseDatos.TABLE_POSTS_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        constantesBaseDatos.TABLE_POSTS_ID_MASCOTA  + " INTEGER," +
                                                        constantesBaseDatos.TABLE_POSTS_POST        + " INTEGER," +
                                                        constantesBaseDatos.TABLE_POSTS_RATE        + " INTEGER," +
                                                        constantesBaseDatos.TABLE_POSTS_LIKED       + " INTEGER," +
                                    " FOREIGN KEY " + "("+ constantesBaseDatos.TABLE_POSTS_ID_MASCOTA + ")"+ " REFERENCES " +
                                    constantesBaseDatos.TABLE_MASCOTAS + "(" +  constantesBaseDatos.TABLE_MASCOTAS_ID + ")" + ")";

        String queryCrearTablaUltimos5Favs =  "CREATE TABLE " + constantesBaseDatos.TABLE_5FAVS             + " ( " +
                                                                constantesBaseDatos.TABLE_5FAVS_POST_ID     + " INTEGER PRIMARY KEY," +
                                                                constantesBaseDatos.TABLE_5FAVS_ID_MASCOTA  + " INTEGER," +
                                                                constantesBaseDatos.TABLE_5FAVS_POST        + " INTEGER," +
                                                                constantesBaseDatos.TABLE_5FAVS_POST_RATE   + " INTEGER," +
                                                                constantesBaseDatos.TABLE_5FAVS_LIKED       + " INTEGER," +
                                            " FOREIGN KEY " + " ( "+ constantesBaseDatos.TABLE_5FAVS_ID_MASCOTA + " ) "+ " REFERENCES " +
                                            constantesBaseDatos.TABLE_MASCOTAS + " ( " +  constantesBaseDatos.TABLE_MASCOTAS_ID + " ) " + " ) ";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaPosts);
        db.execSQL(queryCrearTablaUltimos5Favs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +  constantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " +  constantesBaseDatos.TABLE_POSTS);
        onCreate(db);


    }

    public ArrayList<mascota> obtenerAllMascotas(){
        ArrayList<mascota> mascotas = new ArrayList<>();
        String queryGetAllMAscotas = "Select * FROM " + constantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regMascots = db.rawQuery(queryGetAllMAscotas,null);

        while(regMascots.moveToNext()){
            mascota actualPet = new mascota();
            actualPet.setId_pet(regMascots.getInt(0));
            actualPet.setNombre(regMascots.getString(1));
            actualPet.setPic(regMascots.getInt(2));

            String queryGetMascotaPosts = "SELECT * FROM " + constantesBaseDatos.TABLE_POSTS +
                    " WHERE " + constantesBaseDatos.TABLE_POSTS_ID_MASCOTA + " = " + regMascots.getInt(0);
            Cursor mPosts = db.rawQuery(queryGetMascotaPosts,null);

            while(mPosts.moveToNext()){
                post p = new post(mPosts.getInt(1), mPosts.getInt(0), mPosts.getInt(3), mPosts.getInt(2));
                actualPet.addPosts(p);
            }
            mascotas.add(actualPet);
        }

        return mascotas;
    }

    public mascota obtenerMascota(int pos){
        String queryGetMascota = "SELECT * FROM " + constantesBaseDatos.TABLE_MASCOTAS + " WHERE " +
                                    constantesBaseDatos.TABLE_MASCOTAS_ID + "=" + pos;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor pet = db.rawQuery(queryGetMascota,null);
        if(pet != null && pet.moveToFirst()) {
            mascota petAux = new mascota();
            petAux.setId_pet(pet.getInt(0));
            petAux.setNombre(pet.getString(1));
            petAux.setPic(pet.getInt(2));
            pet.close();
            return petAux;
        }else {
            mascota petdefault = new mascota(1000, "Rocky", 0, R.drawable.bull_terrier);
            return petdefault;
        }

    }

    public void insertMascota(ContentValues cValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(constantesBaseDatos.TABLE_MASCOTAS,null, cValues);
        db.close();
    }

    public void insertMascotaPost(ContentValues cValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(constantesBaseDatos.TABLE_POSTS,null, cValues);
        db.close();
    }

    public ArrayList<post> getMascotaPosts(int mascot_id){
        ArrayList<post> mPosts = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String queryGetMAscotaPosts = "SELECT * FROM " + constantesBaseDatos.TABLE_POSTS +
                                    " WHERE " + constantesBaseDatos.TABLE_POSTS_ID_MASCOTA +  " = "+ mascot_id;
        Cursor posts = db.rawQuery(queryGetMAscotaPosts, null);
        while(posts.moveToNext()){
            post p = new post(posts.getInt(1), posts.getInt(0), posts.getInt(3), posts.getInt(2));
            p.setLiked(posts.getInt(4));
            mPosts.add(p);
        }
        posts.close();
        db.close();
        return mPosts;
    }

    public int getPostRate(int post_id, int mascot_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryGetPostRate = "SELECT " + constantesBaseDatos.TABLE_POSTS_RATE + " FROM " + constantesBaseDatos.TABLE_POSTS +
                                    " WHERE " + constantesBaseDatos.TABLE_POSTS_ID_MASCOTA +  " = "+ mascot_id +
                                    " AND " + constantesBaseDatos.TABLE_POSTS_ID + " = " + post_id;
        Cursor rate = db.rawQuery(queryGetPostRate, null);
        rate.moveToNext();
        int postRate = rate.getInt(0);
        rate.close();
        /*db.close();*/
        return postRate;
    }

    public void ratePost(int post_id, int mascot_id){
        int oldRate = getPostRate(post_id, mascot_id);
        int newRate = oldRate + 1;
        String queryRatePost = "UPDATE "+ constantesBaseDatos.TABLE_POSTS + " SET " + constantesBaseDatos.TABLE_POSTS_RATE +
                            " = " + newRate + ", "+ constantesBaseDatos.TABLE_POSTS_LIKED+ " = " + 1 +
                            " WHERE " +constantesBaseDatos.TABLE_POSTS_ID_MASCOTA +  " = "+ mascot_id +
                            " AND " + constantesBaseDatos.TABLE_POSTS_ID + " = " + post_id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(queryRatePost);
        db.close();
    }

    public void unratePost(int post_id, int mascot_id){
        int newRate = getPostRate(post_id, mascot_id) - 1;
        SQLiteDatabase db = this.getWritableDatabase();
        String queryUnratePost = "UPDATE "+ constantesBaseDatos.TABLE_POSTS + " SET " + constantesBaseDatos.TABLE_POSTS_RATE +
                                " = " + newRate + ", "+ constantesBaseDatos.TABLE_POSTS_LIKED+ " = " + 0 +
                                " WHERE " +constantesBaseDatos.TABLE_POSTS_ID_MASCOTA +  " = "+ mascot_id +
                                " AND " + constantesBaseDatos.TABLE_POSTS_ID + " = " + post_id;
        db.execSQL(queryUnratePost);
        db.close();
    }


    public boolean isEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryCantMascotas = "SELECT COUNT (*) FROM " + constantesBaseDatos.TABLE_MASCOTAS;
        Long numRows = DatabaseUtils.longForQuery(db, queryCantMascotas, null);
        if (numRows >0)
            return false;
        else
            return true;
    }

    public ArrayList<post> getAllPosts(){
        ArrayList<post> posts = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String queryGetAllPosts = "SELECT * FROM " + constantesBaseDatos.TABLE_POSTS;
        Cursor allPosts = db.rawQuery(queryGetAllPosts, null);
        while(allPosts.moveToNext()){
            post p = new post(allPosts.getInt(1), allPosts.getInt(0), allPosts.getInt(3), allPosts.getInt(2));
            p.setLiked(allPosts.getInt(4));
            posts.add(p);
        }
        allPosts.close();
        return posts;
    }

    public Integer get5FavSize(){
        String queryGetSize = "SELECT COUNT (*) FROM "+ constantesBaseDatos.TABLE_5FAVS;
        SQLiteDatabase db = this.getReadableDatabase();
        Long numRows = DatabaseUtils.longForQuery(db, queryGetSize, null);
        Integer cantrows = numRows.intValue();
        return cantrows;
    }

    public void addPostToLast5Fav(int post_id, int mascot_id){
        String queryGetLikedPost = "SELECT * FROM " + constantesBaseDatos.TABLE_POSTS + " WHERE "+
                                constantesBaseDatos.TABLE_POSTS_ID + " = " + post_id + " AND " +
                                constantesBaseDatos.TABLE_POSTS_ID_MASCOTA + " = " + mascot_id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor postliked = db.rawQuery(queryGetLikedPost,null);
        postliked.moveToNext();
        int favsSize = get5FavSize();
        if(favsSize < 5){
            ContentValues cv = new ContentValues();
            cv.put(constantesBaseDatos.TABLE_5FAVS_POST_ID, postliked.getInt(0));
            cv.put(constantesBaseDatos.TABLE_5FAVS_ID_MASCOTA, postliked.getInt(1));
            cv.put(constantesBaseDatos.TABLE_5FAVS_POST, postliked.getInt(2));
            cv.put(constantesBaseDatos.TABLE_POSTS_RATE,postliked.getInt(3));
            cv.put(constantesBaseDatos.TABLE_5FAVS_LIKED,postliked.getInt(4));
            db.insert(constantesBaseDatos.TABLE_5FAVS,null, cv);
            db.close();
        }else{
            String queryDeleteFirstLike = "DELETE FROM " +constantesBaseDatos.TABLE_5FAVS +" WHERE rowid = " +
                                        " (SELECT MAX(rowid) FROM "+ constantesBaseDatos.TABLE_5FAVS +" )";
                    /*"(SELECT rowid FROM "+ constantesBaseDatos.TABLE_5FAVS + " ORDER BY rowid LIMIT 1)";*/
            db.execSQL(queryDeleteFirstLike);
            ContentValues cv = new ContentValues();
            cv.put(constantesBaseDatos.TABLE_5FAVS_POST_ID, postliked.getInt(0));
            cv.put(constantesBaseDatos.TABLE_5FAVS_ID_MASCOTA, postliked.getInt(1));
            cv.put(constantesBaseDatos.TABLE_5FAVS_POST, postliked.getInt(2));
            cv.put(constantesBaseDatos.TABLE_POSTS_RATE,postliked.getInt(3));
            cv.put(constantesBaseDatos.TABLE_5FAVS_LIKED,postliked.getInt(4));
            db.insert(constantesBaseDatos.TABLE_5FAVS,null, cv);
            db.close();
        }

    }

    public void undoPostLikeToLast5Fav(int post_id, int mascot_id){
        String queryFindPostIn5Fav = "DELETE FROM " + constantesBaseDatos.TABLE_5FAVS + " WHERE "+
                constantesBaseDatos.TABLE_5FAVS_POST_ID + " = " + post_id + " AND " +
                constantesBaseDatos.TABLE_5FAVS_ID_MASCOTA + " = " + mascot_id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(queryFindPostIn5Fav);
        db.close();
    }

    public ArrayList<post> getLast5Favs(){
        ArrayList<post> posts = new ArrayList<>();
        String queryGetLast5FAvs = "SELECT * FROM " + constantesBaseDatos.TABLE_5FAVS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor postsliked = db.rawQuery(queryGetLast5FAvs,null);
        while(postsliked.moveToNext()){
            post p = new post(postsliked.getInt(1), postsliked.getInt(0), postsliked.getInt(3), postsliked.getInt(2));
            p.setLiked(postsliked.getInt(4));
            posts.add(p);
        }
        postsliked.close();
        db.close();
        return posts;
    }

    public String getPetName(int id_pet){
        String queryGetName = "SELECT " + constantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " FROM " + constantesBaseDatos.TABLE_MASCOTAS +
                                " WHERE " + constantesBaseDatos.TABLE_MASCOTAS_ID + " = " + id_pet;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(queryGetName, null);
        c.moveToNext();
        String name = c.getString(0);
        return name;
    }


}


