package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;

public class Interestingness {
    @Expose
    private Photos photos;
    @Expose
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
