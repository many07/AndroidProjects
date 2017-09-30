package com.altice.jsonconsume.jsonconsumeproyect;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Manuel on 8/5/2017.
 */

public interface MyRemoteService {

    @GET("example/practica.json")
    Call<List<Item>> getItem();


}
