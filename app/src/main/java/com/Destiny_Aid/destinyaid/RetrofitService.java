package com.Destiny_Aid.destinyaid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("/Destiny/wondor.json")
    Call<Collection_wonder_Item> getBoardJson();
}
