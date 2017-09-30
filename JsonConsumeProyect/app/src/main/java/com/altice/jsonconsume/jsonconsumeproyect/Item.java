package com.altice.jsonconsume.jsonconsumeproyect;

/**
 * Created by Manuel on 8/5/2017.
 */

public class Item {
    public int id;
    public String name;
    public String description;
    public String image_url;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
