package com.example.mytestappstack.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite_images")
public class FavoriteImages {
    @PrimaryKey(autoGenerate = true)
    public int favId;

    @ColumnInfo(name = "image_id")
    public String image_id;

    @ColumnInfo(name = "image_url")
    public String image_url;

    public FavoriteImages(String image_id, String image_url) {
        this.image_id = image_id;
        this.image_url = image_url;
    }

    public int getFavId() {
        return favId;
    }

    public void setFavId(int favId) {
        this.favId = favId;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
