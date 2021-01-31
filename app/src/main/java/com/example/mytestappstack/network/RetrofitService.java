package com.example.mytestappstack.network;

import com.example.mytestappstack.model.content.Interestingness;
import com.example.mytestappstack.model.content.SizeModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitService {

    @GET("/services/rest/?method=flickr.interestingness.getList")
    Observable<Interestingness> getInterestingness(@Query("per_page") String perPage, @Query("page") String page);

    @GET("/services/rest/?method=flickr.photos.getSizes")
    Observable<SizeModel> getImageSize(@Query("photo_id") String perPage);
}
