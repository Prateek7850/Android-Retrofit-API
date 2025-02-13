package com.example.productlist.api;

import com.example.productlist.Model.UserModel;
import com.example.productlist.Model.UserModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APIInterface {

    //If Json data starts from [] list then give List in call
    //If json data starts form {} Json object then give Object in call
    @GET("posts")
    Call<List<UserModelItem>> getUserData();

    //getting data as per the Id
    @GET("posts/{id}")
    Call<UserModelItem> getDataWithId(
            @Path("id") int userId
    );

}
