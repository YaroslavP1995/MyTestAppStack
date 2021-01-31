package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Sizes {
    @SerializedName("canblog")
    @Expose
    private long canblog;
    @SerializedName("canprint")
    @Expose
    private long canprint;
    @SerializedName("candownload")
    @Expose
    private long candownload;
    @SerializedName("size")
    @Expose
    private List<Size> size = new ArrayList<Size>();

    public Sizes() {
    }

    public Sizes(long canblog, long canprint, long candownload, List<Size> size) {
        super();
        this.canblog = canblog;
        this.canprint = canprint;
        this.candownload = candownload;
        this.size = size;
    }

    public long getCanblog() {
        return canblog;
    }

    public void setCanblog(long canblog) {
        this.canblog = canblog;
    }

    public Sizes withCanblog(long canblog) {
        this.canblog = canblog;
        return this;
    }

    public long getCanprint() {
        return canprint;
    }

    public void setCanprint(long canprint) {
        this.canprint = canprint;
    }

    public Sizes withCanprint(long canprint) {
        this.canprint = canprint;
        return this;
    }

    public long getCandownload() {
        return candownload;
    }

    public void setCandownload(long candownload) {
        this.candownload = candownload;
    }

    public Sizes withCandownload(long candownload) {
        this.candownload = candownload;
        return this;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

    public Sizes withSize(List<Size> size) {
        this.size = size;
        return this;
    }

}
