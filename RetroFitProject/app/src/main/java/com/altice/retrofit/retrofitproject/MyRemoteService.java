package com.altice.retrofit.retrofitproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Manuel on 8/5/2017.
 */

public interface MyRemoteService {

    @GET("example/items.json")
    Call<List<Item>> getItem();

    @FormUrlEncoded
    @POST("example/form.php")
    Call<FormResponse> postForm(@Field("name") String name);




}
