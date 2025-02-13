package com.example.productlist.api;

import com.example.productlist.Model.ProductList.ProductListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface2 {
    //If Json data starts from [] list then give List in call
    //If json data starts form {} Json object then give Object in call

    @GET("products")
    Call<ProductListResponse> getProductList();

}
