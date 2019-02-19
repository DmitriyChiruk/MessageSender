package com.messagesender.messagesender;

//import android.telecom.Call;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("?i=onions")
    public retrofit2.Call<DataModel> getRecipe();
}
