package com.example.catetin.model;

import android.net.Uri;

public class UserModel {
    String id_user;
    Uri uriImage;
    String name;
    String email;

    public UserModel(String id_user, Uri uriImage, String name, String email) {
        this.id_user = id_user;
        this.uriImage = uriImage;
        this.name = name;
        this.email = email;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Uri getUriImage() {
        return uriImage;
    }

    public void setUriImage(Uri uriImage) {
        this.uriImage = uriImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
