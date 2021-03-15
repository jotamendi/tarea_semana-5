package com.jmdevs.petagram.pojo;

import android.content.Context;

import com.jmdevs.petagram.db.BaseDatos;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class mascota {

    private int id_pet;
    private String nombre;
    private int pic;
    /*private Integer rate;*/
    private ArrayList<post> posts;

    /*private Integer edad;
    private String descripcion;*/

    public mascota(){
        posts = new ArrayList<>();
        nombre= "---";
    }

    public mascota(int id, String nom, Integer ed, int img){
        id_pet = id;
        nombre = nom;
        /*edad = ed;*/
        pic = img;
        /*rate = 0;
        descripcion = "---";*/
        posts = new ArrayList<>();
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*-public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }*/

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    /*public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }*/

    public Integer getRate(int post_id, Context c) {
       post p = posts.get(posts.size()-1);
       int rate = 0;
       if (p != null){
           BaseDatos bd = new BaseDatos(c);
           rate =  bd.getPostRate(post_id, id_pet);
           bd.close();
       }

        return rate;
    }

   /* public void setRate(Integer rate) {
        this.rate = rate;
    }*/

    public void incRate(int postID, Context c){
        int i = 0;
        boolean notFound = true;
        while (notFound && i<posts.size()) {
            if (posts.get(i).getPost_id() == postID) {
               /* posts.get(i).setRate(posts.get(i).getRate() + 1);*/
                BaseDatos bd = new BaseDatos(c);
                bd.ratePost(postID, id_pet);
                bd.close();
                notFound = false;
            }
            i++;
        }
    }

    public void decRate(int postID, Context c){
        int i = 0;
        boolean notFound = true;
        while (notFound && i<posts.size()) {
            if (posts.get(i).getPost_id() == postID) {
                /*posts.get(i).setRate(posts.get(i).getRate() - 1);*/
                BaseDatos bd = new BaseDatos(c);
                bd.unratePost(postID, id_pet);
                bd.close();
                notFound = false;
            }
            i++;

        }
    }

    public ArrayList<post> getPosts() {
        return posts;
    }

    public void addPosts(post p) {
        posts.add(p);
    }

}
