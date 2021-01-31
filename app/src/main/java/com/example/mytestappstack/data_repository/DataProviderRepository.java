package com.example.mytestappstack.data_repository;

public class DataProviderRepository {

    private static DataRepositoryView dataRepositoryView;

    public static DataRepositoryView getDataRepositoryView() {
        if (dataRepositoryView == null) {
            dataRepositoryView = new DataRepository();
        }
        return dataRepositoryView;
    }
}
