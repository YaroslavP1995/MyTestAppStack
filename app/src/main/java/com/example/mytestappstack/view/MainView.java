package com.example.mytestappstack.view;

import androidx.annotation.NonNull;

import com.example.mytestappstack.model.content.Interestingness;
import com.example.mytestappstack.model.content.SizeModel;

public interface MainView {
    void OnInterestingness(@NonNull Interestingness typeModel);

    void OnGetImageSize(@NonNull SizeModel typeModel);

    void handleError(Throwable throwable);

}
