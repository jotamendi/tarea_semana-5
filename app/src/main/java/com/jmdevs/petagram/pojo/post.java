package com.jmdevs.petagram.pojo;

public class post {

    private String id_pet;
    private int rate;
    private Integer pic;

    public post(String id, int r, Integer picture){
        id_pet = id;
        rate = r;
        pic = picture;
    }

    public String getId_pet() {
        return id_pet;
    }

    public void setId_pet(String id_pet) {
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


}
