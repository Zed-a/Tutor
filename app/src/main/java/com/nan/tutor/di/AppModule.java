package com.nan.tutor.di;


import android.app.Application;
import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.nan.tutor.BuildConfig;
import com.nan.tutor.network.GlobalRequestInterceptor;
import com.nan.tutor.network.service.LoginService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author nan
 * @date 2019/2/27
 */
@Module
class AppModule {
    @Singleton
    @Provides
    @ForApplication
    Context getAppContext(Application application) {
        return application.getApplicationContext();
    }

    /**
     * business OkHttpClient
     */
    @Provides
    @Singleton
    OkHttpClient okHttpClient(GlobalRequestInterceptor globalRequestInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(5, 59, TimeUnit.SECONDS))
                .connectTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        builder.addInterceptor(globalRequestInterceptor);
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    @ForGlide
    OkHttpClient glideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(4, 59, TimeUnit.SECONDS))
                .retryOnConnectionFailure(true);
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit retrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("http://192.168.1.1:8080")
//                .baseUrl("http://129.28.81.66:8080")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    LoginService loginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @Provides
    Gson gson() {
        return new Gson();
    }
}
