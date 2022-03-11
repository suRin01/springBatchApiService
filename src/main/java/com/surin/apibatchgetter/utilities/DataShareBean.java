package com.surin.apibatchgetter.utilities;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataShareBean <T> {

    private Map<String, T> shareDataMap;


    public DataShareBean () {
        this.shareDataMap = new HashMap<>();
    }

    public void putData(String key, T data) {
        if (shareDataMap ==  null) {
            System.out.println("Map is not initialize");
            return;
        }

        shareDataMap.put(key, data);
    }

    public T getData (String key){

        if (shareDataMap == null) {
            return null;
        }

        return shareDataMap.get(key);
    }

    public int getSize () {
        if (this.shareDataMap == null) {
            System.out.println(("Map is not initialize"));
            return 0;
        }

        return shareDataMap.size();
    }

    public void updateData(String key, T data){
        if (shareDataMap ==  null) {
            System.out.println("Map is not initialize");
            return;
        }
        shareDataMap.replace(key, data);
    }
}
