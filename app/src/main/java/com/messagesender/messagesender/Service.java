package com.messagesender.messagesender;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public static Api getApi(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.recipepuppy.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
        .build();
        Api api = retrofit.create(Api.class);
        return api;
    }

}
