package com.manuel.altice.fireapp;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by manuel on 15/08/17.
 */

@IgnoreExtraProperties
public class User {

    String username;
    String email;

    public User(){
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
