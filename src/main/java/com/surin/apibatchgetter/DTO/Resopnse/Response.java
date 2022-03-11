package com.surin.apibatchgetter.DTO.Resopnse;

import lombok.Getter;

@Getter
public class Response<T> {
    private Header header;
    private Body<T> body;
}
