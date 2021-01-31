package com.example.mytestappstack.data_repository;

import com.example.mytestappstack.model.content.Interestingness;
import com.example.mytestappstack.model.content.SizeModel;

import rx.Observable;

public interface DataRepositoryView {

    Observable<Interestingness> getInterestingness(String perPage, String page);

    Observable<SizeModel> getSizeImage(String photoId);

}
