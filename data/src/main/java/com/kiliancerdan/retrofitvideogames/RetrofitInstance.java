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

    private final static String API_KEY = "***";
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
                        .addQueryParameter("token", API_KEY)
                        .build();

                Request.Builder requestBuilder = original.newBuilder().url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.igdb.com/api/v1/")
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
