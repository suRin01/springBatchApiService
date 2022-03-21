package com.surin.apibatchgetter.DTO.WeatherResponse;

import com.surin.apibatchgetter.DTO.Resopnse.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponseStructure<T> {
    private WeatherResponse<T> response;

    public List<T> getItems(){
        return this.getResponse().getBody().getItems().getItem();
    }
}
