package com.surin.apibatchgetter.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.surin.apibatchgetter.interfaces.SpotApi;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class SpotClient {
    private static final String BASE_URL = "http://api.visitkorea.or.kr";

    public static SpotApi getApiService(){
        return getInstance().create(SpotApi.class);
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
