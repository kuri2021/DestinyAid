package com.Destiny_Aid.destinyaid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {
    static String baseurl="http://kuri.dothome.co.kr/";

    static Retrofit getRetrofitInstanceGson(){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(baseurl);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        return retrofit;
    }

    static Retrofit getRetrofitInstanceScalars(){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(baseurl);
        builder.addConverterFactory(ScalarsConverterFactory.create());
        Retrofit retrofit=builder.build();

        return retrofit;
    }

}
