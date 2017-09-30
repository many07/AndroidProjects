package com.manuel.altice.firebaseapp;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by manuel on 15/08/17.
 */

@IgnoreExtraProperties
public class User {

    public String username;
    public String email;

    public User(){
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
