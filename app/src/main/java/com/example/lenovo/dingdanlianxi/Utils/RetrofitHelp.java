package com.example.lenovo.dingdanlianxi.Utils;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHelp {
    private static OkHttpClient okHttpClient;
    private static ServiceApi apiService;
    static {
        initOkhttp();
    }
    private static OkHttpClient initOkhttp() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelp.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()

                            .build();
                }
            }
        }
        return okHttpClient;
    }
    public static ServiceApi getAPI(){
        if (apiService==null){
            synchronized (RetrofitHelp.class){
                if (apiService==null){
                    apiService=RetrofitHelp.CreateURL(ServiceApi.class,Api.BASE_URL);
                }
            }
        }
        return apiService;
    }
    public static <T>T CreateURL(Class<T> t,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(t);
    }

}