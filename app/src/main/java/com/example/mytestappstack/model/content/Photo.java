package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;

public class Photo {
    @Expose
    private String id;
    @Expose
    private String owner;
    @Expose
    private String secret;
    @Expose
    private String server;
    @Expose
    private int farm;
    @Expose
    private String title;
    @Expose
    private int ispublic;
    @Expose
    private int isfriend;
    @Expose
    private int isfamily;
    @Expose
    private String url_s;

    public Photo(String id, String url_s) {
        this.id = id;
        this.url_s = url_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }


    public String getOwner() {
        return owner;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getSecret() {
        return secret;
    }


    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }
}
