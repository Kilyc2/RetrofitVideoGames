package com.kiliancerdan.retrofitvideogames;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitInstance {

    private static final String API_KEY = "***";
    private static RetrofitInstance retrofitInstance = null;
    private Retrofit retrofit;

    private RetrofitInstance() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor requestInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("fields", "id,name,slug,summary,aggregated_rating,first_release_date,cover,videos")
                        .build();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("X-Mashape-Key", API_KEY)
                        .header("Accept", "application/json")
                        .url(url);

                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://igdbcom-internet-game-database-v1.p.mashape.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    static Retrofit getRetrofit() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitInstance();
        }
        return retrofitInstance.retrofit;
    }
}
