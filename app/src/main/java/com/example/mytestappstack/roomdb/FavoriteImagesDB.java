package com.example.mytestappstack.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = FavoriteImages.class, version = 1, exportSchema = false)

public abstract class FavoriteImagesDB extends RoomDatabase {

    public abstract FavoriteDao getFavoriteDao();
}
