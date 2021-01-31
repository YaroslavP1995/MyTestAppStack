package com.example.mytestappstack.network;

import android.util.Log;

import com.example.mytestappstack.model.MainErrorModel;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ExceptionInterceptor implements Interceptor {
    private final String LOG_TAG = getClass().getSimpleName();

    public static Interceptor create() {
        return new ExceptionInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final Response response = chain.proceed(request);
        if (!response.isSuccessful()) {
            parseErrorBody(response);
        }
        return response;
    }

    private void parseErrorBody(Response response) throws IOException {
        final String errorBody;
        errorBody = response.body().string();
        final MainErrorModel errorResponse = new Gson().fromJson(errorBody, MainErrorModel.class);
        Log.d(LOG_TAG, "error body " + errorBody.toString());
        if (errorBody.contains("not found")) {
            errorResponse.setCode(402);
        }
        if (errorResponse.getCode() != null && errorResponse.getCode() != 0) {
            throw errorResponse;
        }
    }
}
