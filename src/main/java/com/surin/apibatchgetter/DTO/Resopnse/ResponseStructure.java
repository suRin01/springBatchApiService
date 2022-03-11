package com.surin.apibatchgetter.DTO.Resopnse;


import lombok.Getter;

import java.util.List;

@Getter
public class ResponseStructure<T> {
    private Response<T> response;

    public List<T> getItems(){
        return this.getResponse().getBody().getItems().getItem();
    }
}
