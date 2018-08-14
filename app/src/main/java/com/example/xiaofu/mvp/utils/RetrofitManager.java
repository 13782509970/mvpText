package com.example.xiaofu.mvp.utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by XiaoFu on 2018/7/27.
 */

public class RetrofitManager {
    private Retrofit mRetrofit;
    private String baseUrl;
    private static RetrofitManager mRetrofitManager;
    public static OkHttpClient okHttpClient;

    //静态块,获取OkHttpClient对象
    static {
        getOkHttpClient();
    }

    private RetrofitManager(String baseUrl) {
        this.baseUrl = baseUrl;
        initRetrofit();
    }

    public static synchronized RetrofitManager getInstance(String baseUrl) {
        if (mRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager(baseUrl);
                }
            }
        }
        return mRetrofitManager;
    }

    //单例模式获取okhttp
    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                            //打印拦截器日志
                            .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时时间
                            .readTimeout(15, TimeUnit.SECONDS)//设置读取超时时间
                            .writeTimeout(15, TimeUnit.SECONDS)//设置写入超时时间
//                            .addInterceptor(new OkHttpInterceptor())//添加拦截器
                            .build();

                }
            }
        }
        return okHttpClient;
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    /**
     * 创建相应的服务接口
     */
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}
