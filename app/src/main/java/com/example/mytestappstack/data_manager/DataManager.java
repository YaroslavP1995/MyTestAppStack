package com.example.mytestappstack.data_manager;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.example.mytestappstack.roomdb.FavoriteImages;
import com.example.mytestappstack.roomdb.FavoriteImagesDB;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataManager {

    private Context context;
    private FavoriteImagesDB favoriteImagesDB;

    public DataManager(Context context) {
        this.context = context;
        favoriteImagesDB = Room.databaseBuilder(context, FavoriteImagesDB.class, "favorite_images.db").build();
    }

    public void addData(final DataCallBack dataCallBack, final String photoId, final String photoUrl) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                FavoriteImages favoriteImages = new FavoriteImages(photoId, photoUrl);
                favoriteImagesDB.getFavoriteDao().insertFavoriteImages(favoriteImages);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                dataCallBack.dataAdded();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                dataCallBack.errorAdded();
            }
        });
    }

    @SuppressLint("CheckResult")
    public void loadFavoriteImage(final DataCallBack dataCallBack) {
        favoriteImagesDB.getFavoriteDao().getFavoriteImages().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<FavoriteImages>>() {
            @Override
            public void accept(List<FavoriteImages> favoriteImages) throws Exception {
                dataCallBack.loadFavoriteImage(favoriteImages);
            }
        });
    }
}
