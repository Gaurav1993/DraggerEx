package com.example.draggerex.dragger.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule
{
    String baseurl;
    public NetworkModule (String baseurl)
    {
        this.baseurl=baseurl;
    }


    @Provides
    @Singleton
            Gson ProviderGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }
    @Singleton
    @Provides
    Retrofit retrofit(Gson gson)
    {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(baseurl).build();
    }

}
