package com.nan.tutor.network;

import android.content.Context;

import com.nan.tutor.di.ForApplication;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author nan
 * @date 2019/2/27
 */
public class GlobalRequestInterceptor implements Interceptor {

    private static final int TOKEN_EXPIRED_OR_INVALID = 401;
    private final Context context;

    @Inject
    GlobalRequestInterceptor(@ForApplication Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        urlBuilder.addQueryParameter("ts", String.valueOf(System.currentTimeMillis()))
                .addQueryParameter("platform", "Android")
//                .addQueryParameter("app_version", BuildConfig.VERSION_NAME)
//                .addQueryParameter("device_id", DeviceUtils.getDeviceId(context))
                .addQueryParameter("android_version", String.valueOf(android.os.Build.VERSION.SDK_INT));
        Request tempRequest = request.newBuilder().url(urlBuilder.build()).build();
//        urlBuilder.addQueryParameter("sign", SecurityUtil.signRequest(tempRequest));

        Headers.Builder headerBuilder = request.headers().newBuilder();
//        if (!TextUtils.isEmpty(userPrefs.getAuthToken())) {
//            headerBuilder.add("Authorization", userPrefs.getAuthToken());
//        } else {
//        }
        Request newRequest = chain.request().newBuilder()
                .url(urlBuilder.build())
                .headers(headerBuilder.build())
                .build();

        Response response = chain.proceed(newRequest);
//        if (response.code() == TOKEN_EXPIRED_OR_INVALID) {
//            EventBus.getDefault().post(new TokenExpiredEvent());
//        }
        return response;
    }
}
