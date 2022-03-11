package com.surin.apibatchgetter.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestApi {
    @GET("/api/breeds/image/random/")
    Call<Object> getTest();

    // 단기 예보
    @GET("/1360000/VilageFcstInfoService_2.0/getVilageFcst")
    Call<Object> getVillageForecast(@Query("serviceKey") String serviceKey,
                                   @Query("numOfRows") String numOfRows,
                                   @Query("pageNo") String pageNo,
                                   @Query("dataType") String dataType,
                                   @Query("base_date") String base_date,
                                   @Query("base_time") String base_time,
                                   @Query("nx") String nx,
                                   @Query("ny") String ny);



}
