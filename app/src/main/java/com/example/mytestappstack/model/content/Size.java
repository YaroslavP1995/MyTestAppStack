package com.example.mytestappstack.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Size implements Serializable {
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("width")
    @Expose
    private long width;
    @SerializedName("height")
    @Expose
    private long height;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("media")
    @Expose
    private String media;

    public Size() {
    }


    public Size(String label, long width, long height, String source, String url, String media) {
        super();
        this.label = label;
        this.width = width;
        this.height = height;
        this.source = source;
        this.url = url;
        this.media = media;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Size withLabel(String label) {
        this.label = label;
        return this;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public Size withWidth(long width) {
        this.width = width;
        return this;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public Size withHeight(long height) {
        this.height = height;
        return this;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Size withSource(String source) {
        this.source = source;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Size withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Size withMedia(String media) {
        this.media = media;
        return this;
    }
}
