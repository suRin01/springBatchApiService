package com.surin.apibatchgetter.DTO.WeatherResponse;

import lombok.Getter;

import java.util.List;

@Getter
public class WeatherItem<T> {
    private List<T> item;
}
