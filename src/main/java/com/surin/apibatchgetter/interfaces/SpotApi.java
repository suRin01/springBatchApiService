package com.surin.apibatchgetter.interfaces;

import com.surin.apibatchgetter.DTO.Resopnse.ResponseStructure;
import com.surin.apibatchgetter.entities.Spot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpotApi {
    // 위치 기반 조회
    @GET("/openapi/service/rest/KorService/areaBasedList")
    Call<ResponseStructure<Spot>> getAreaBasedList(@Query("serviceKey") String serviceKey,
                                                    @Query("numOfRows") int numOfRows,
                                                    @Query("pageNo") int pageNo,
                                                    @Query("MobileOS") String MobileOS,
                                                    @Query("MobileApp") String MobileApp,
                                                    @Query("areaCode") String areaCode,
                                                    @Query("_type") String _type);

    @GET("/openapi/service/rest/KorService/areaCode")
    Call<ResponseStructure<Spot>> getAreaCodeList(@Query("serviceKey") String serviceKey,
                                                    @Query("areaCode") int areaCode,
                                                    @Query("numOfRows") int numOfRows,
                                                    @Query("pageNo") int pageNo,
                                                    @Query("MobileOS") String MobileOS,
                                                    @Query("MobileApp") String MobileApp,
                                                    @Query("sigunguCode") int sigunguCode,
                                                    @Query("_type") String _type);

}
