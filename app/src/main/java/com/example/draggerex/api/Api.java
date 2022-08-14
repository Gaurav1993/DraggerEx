package com.example.draggerex.api;

import com.example.draggerex.entity.entity_module;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api
{

    @GET("/todos/{id}")
    Call<entity_module> getTodo(@Path("id")int id);
}
