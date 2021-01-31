package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Photos {
    @Expose
    private int page;
    @Expose
    private int pages;
    @Expose
    private int perpage;
    @Expose
    private String total;
    @Expose
    private List<Photo> photo = new ArrayList<Photo>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
