package com.example.productlist.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient2 {

    private static APIClient2 instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://dummyjson.com/";

    private APIClient2(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


    public static synchronized  APIClient2 getInstance(){
        if(instance == null){
            instance = new APIClient2();
        }
        return instance;
    }

    public APIInterface2 getAPI(){
        return retrofit.create(APIInterface2.class);
    }

}
