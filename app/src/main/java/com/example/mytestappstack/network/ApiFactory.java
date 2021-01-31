package com.example.mytestappstack.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mytestappstack.BuildConfig.API_ENDPOINT;
import static com.example.mytestappstack.BuildConfig.CLIENT_KEY;

public class ApiFactory {
    private static RetrofitService sService;

    private static RetrofitService createService() {
        return new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    public static RetrofitService getRetrofitService() {
        RetrofitService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = createService();
                }
            }
        }
        return service;
    }

    static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .addInterceptor(ExceptionInterceptor.create())
            .addInterceptor(LoggingInterceptor.create())
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("api_key", CLIENT_KEY)
                            .addQueryParameter("format", "json")
                            .addQueryParameter("nojsoncallback", "1")
                            .addQueryParameter("extras", "url_s")
                            .build();

                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);
                    Request request = requestBuilder
                            .build();

                    return chain.proceed(request);

                }
            }).build();

}
