package com.example.mytestappstack.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FavoriteDao {
    @Query("select * from favorite_images")
    Flowable<List<FavoriteImages>> getFavoriteImages();

    @Insert
    void insertFavoriteImages(FavoriteImages favoriteImages);

}
