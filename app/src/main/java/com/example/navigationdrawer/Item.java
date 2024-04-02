package com.example.navigationdrawer;

public class Item {
    String name, description;
    int img;

    public Item (int img, String name, String description){
        this.img = img;
        this.name = name;
        this.description = description;

    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setImg(int img){
        this.img = img;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){return description;}

    public String getName(){ return name;}

    public int getImg(){
        return img;
    }
}
