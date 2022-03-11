package com.surin.apibatchgetter.DTO.Resopnse;

import lombok.Getter;

@Getter
public class Body<T> {
    private Items<T> items;
    private float numOfRows;
    private float pageNo;
    private float totalCount;
}
