package com.jmdevs.petagram.pojo;

public class post {

    private int id_pet;
    private int post_id;
    private int rate;
    private Integer pic;
    private Integer liked;

    public post(int id, int post_id, int r, Integer picture){
        id_pet = id;
        this.post_id = post_id;
        rate = r;
        pic = picture;
        liked = 0;
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Integer getPic() {
        return pic;
    }

    public void setPic(Integer pic) {
        this.pic = pic;
    }


    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }
}
