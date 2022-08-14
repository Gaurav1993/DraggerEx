package com.example.draggerex.dragger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{

    Application application;

   public  AppModule(Application application)
    {
        this.application=application;
    }


    @Provides
    @Singleton
    Application getApplication()
    {
        return application;
    }
}
