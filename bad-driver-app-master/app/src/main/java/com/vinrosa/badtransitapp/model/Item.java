package com.vinrosa.badtransitapp.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vinliangx on 8/7/17.
 */
@Entity
public class Item {
    @Id
    public Integer id;
    public String key;
    public Integer rating;
    public String image;
    public String email;
    public String description;
    public Date date;


    @Generated(hash = 1199413007)
    public Item(Integer id, String key, Integer rating, String image, String email,
            String description, Date date) {
        this.id = id;
        this.key = key;
        this.rating = rating;
        this.image = image;
        this.email = email;
        this.description = description;
        this.date = date;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }


    @Override
    public String toString() {
        return "Item{" +
                "rating=" + rating +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item)
            return this.key.equals(((Item) obj).key);
        else
            return super.equals(obj);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
