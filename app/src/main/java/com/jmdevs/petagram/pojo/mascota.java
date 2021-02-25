package com.jmdevs.petagram.pojo;

import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class mascota {

    private String id_pet;
    private String nombre;
    private int pic;
    private Integer rate;
    private ArrayList<post> posts;

    private Integer edad;
    private String descripcion;

    public mascota(String id, String nom, Integer ed, int img){
        id_pet = id;
        nombre = nom;
        edad = ed;
        pic = img;
        rate = 0;
        descripcion = "---";
        posts = new ArrayList<>();
    }

    public String getId_pet() {
        return id_pet;
    }

    public void setId_pet(String id_pet) {
        this.id_pet = id_pet;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void incRate(){
        rate = rate + 1;
    }

    public void decRate(){
        rate = rate - 1;
    }

    public ArrayList<post> getPosts() {
        return posts;
    }

    public void addPosts(post p) {
        posts.add(p);
    }

}
