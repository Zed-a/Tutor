package com.nan.tutor.network.service;


import com.nan.tutor.bean.Student;
import com.nan.tutor.network.JsonDataResp;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by nan on 2019/2/27.
 */
public interface LoginService {
    @FormUrlEncoded
    @POST("auth/register")
    Observable<JsonDataResp<Student>> rigister(
            @Field("phone") String phone,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("auth/login")
    Observable<JsonDataResp<Student>> login(
            @Field("phone") String phone,
            @Field("password") String password
    );
}
