package com.example.cll.caolilu1508b20171123.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2017/11/20.
 */

public class RetrofitUtil {
    //单例模式
    private static RetrofitUtil retrofitUtil;
    private static Retrofit retrofit;

    public RetrofitUtil() {
    }
    public static RetrofitUtil getInstance(){
        if (retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil==null){
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }
    //封装Retrofit
    private Retrofit getRetrofit(String url){
        //创建拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("Error", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建OkHttpClicent对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();
        //创建retrofit对象,封装OkHhttp , Gson , RxJava
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public <T> T getApiService(String url,Class<T> cl){
        Retrofit retrofit = getRetrofit(url);
        return retrofit.create(cl);
    }
}
