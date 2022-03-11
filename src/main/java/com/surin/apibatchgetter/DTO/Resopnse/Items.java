package com.surin.apibatchgetter.DTO.Resopnse;

import lombok.Getter;

import java.util.List;

@Getter
public class Items<T> {
    private List<T> item;
}
