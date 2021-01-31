package com.example.mytestappstack.data_manager;

import com.example.mytestappstack.roomdb.FavoriteImages;

import java.util.List;

public interface DataCallBack {
    void dataAdded();
    void errorAdded();
    void loadFavoriteImage(List<FavoriteImages> favoriteImages);
}
