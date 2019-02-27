package com.nan.tutor.network.service;


import com.nan.tutor.network.JsonDataResp;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nan on 2019/2/27.
 */
public interface LoginService {
    @GET("info")
    Observable<JsonDataResp> connectTest();

    @GET("users/questions")
    Observable<JsonDataResp> getQuestion();
}
