package com.surin.apibatchgetter.interfaces;

import com.surin.apibatchgetter.DTO.WeatherResponse.WeatherResponseStructure;
import com.surin.apibatchgetter.entities.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    // 위치 기반 조회
    @GET("/1360000/VilageFcstInfoService_2.0/getVilageFcst")
    Call<WeatherResponseStructure<Weather>> getWeatherOnXY(@Query("serviceKey") String serviceKey,
                                                           @Query("numOfRows") int numOfRows,
                                                           @Query("pageNo") int pageNo,
                                                           @Query("dataType") String dataType,
                                                           @Query("base_date") String base_date,
                                                           @Query("base_time") String base_time,
                                                           @Query("nx") int nx,
                                                           @Query("ny") int ny);


}

