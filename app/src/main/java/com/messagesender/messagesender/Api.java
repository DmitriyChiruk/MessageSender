package com.messagesender.messagesender;

import android.telecom.Call;

import retrofit2.http.GET;

public interface Api {
    @GET("/")
    public Call getRecipe();
}
