package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SizeModel implements Serializable {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("stat")
    @Expose
    private String stat;

    public SizeModel() {
    }


    public SizeModel(Sizes sizes, String stat) {
        super();
        this.sizes = sizes;
        this.stat = stat;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public SizeModel withSizes(Sizes sizes) {
        this.sizes = sizes;
        return this;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public SizeModel withStat(String stat) {
        this.stat = stat;
        return this;
    }
}
