package com.surin.apibatchgetter.DTO.WeatherResponse;

import lombok.Getter;

@Getter
public class WeatherBody <T>{
    private String dataType;
    private WeatherItem<T> items;
    private Integer pageNo;
    private Integer numOfRows;
    private Integer totalCount;
}
