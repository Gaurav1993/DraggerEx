package com.example.draggerex.dragger.component;

import com.example.draggerex.MainActivity;
import com.example.draggerex.dragger.module.AppModule;
import com.example.draggerex.dragger.module.NetworkModule;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent
{


    void inject(MainActivity mainActivity);
}
