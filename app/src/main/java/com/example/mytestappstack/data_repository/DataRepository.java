package com.example.mytestappstack.data_repository;

import com.example.mytestappstack.model.content.Interestingness;
import com.example.mytestappstack.model.content.SizeModel;
import com.example.mytestappstack.network.ApiFactory;

import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

public class DataRepository implements DataRepositoryView {

    @Override
    public Observable<Interestingness> getInterestingness(String perPage, String page) {
        return ApiFactory.getRetrofitService()
                .getInterestingness(perPage, page)
                .flatMap(Observable::just)
                .compose(RxUtils.async());
    }

    @Override
    public Observable<SizeModel> getSizeImage(String photoId) {
        return ApiFactory.getRetrofitService()
                .getImageSize(photoId)
                .flatMap(Observable::just)
                .compose(RxUtils.async());
    }
}
