package com.surin.apibatchgetter.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.surin.apibatchgetter.interfaces.WeatherApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class WeatherClient {
    private static final String BASE_URL = "http://apis.data.go.kr/";
    public static WeatherApi getApiService(){
        return getInstance().create(WeatherApi.class);
    }




    public static Retrofit getInstance(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


}
