package com.surin.apibatchgetter.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    private static final String BASE_URL = "http://apis.data.go.kr";

    public static WeatherClient getApiService(){
        return getInstance().create(WeatherClient.class);
    }

    public static Retrofit getInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


}
