package com.surin.apibatchgetter.DTO.WeatherResponse;

import lombok.Getter;

@Getter
public class WeatherResponse<T> {
    private WeatherHeader header;
    private WeatherBody<T> body;
}
