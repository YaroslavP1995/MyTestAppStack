package com.example.mytestappstack.presenter;

import com.example.mytestappstack.data_repository.DataProviderRepository;
import com.example.mytestappstack.view.MainView;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getType(String perPage, String page) {
        DataProviderRepository.getDataRepositoryView()
                .getInterestingness(perPage, page)
                .subscribe(mainView::OnInterestingness,
                        throwable -> {
                            mainView.handleError(throwable);
                        });
    }

    public void getSizeImage(String photoId) {
        DataProviderRepository.getDataRepositoryView()
                .getSizeImage(photoId)
                .subscribe(mainView::OnGetImageSize,
                        throwable -> {
                            mainView.handleError(throwable);
                        });
    }
}
