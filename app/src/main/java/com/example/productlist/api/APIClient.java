package com.example.productlist.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static APIClient instance;
    private Retrofit retrofit;
    //for adding a page in front of this url will create interface
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private APIClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static synchronized  APIClient getInstance(){
        if(instance == null){
            instance = new APIClient();
        }
        return instance;
    }

    public APIInterface getAPI(){
        return retrofit.create(APIInterface.class);
    }

}
