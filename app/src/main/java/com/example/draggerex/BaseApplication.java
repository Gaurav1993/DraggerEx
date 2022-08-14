package com.example.draggerex;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.example.draggerex.dragger.component.AppComponent;
import com.example.draggerex.dragger.component.DaggerAppComponent;
import com.example.draggerex.dragger.module.AppModule;
import com.example.draggerex.dragger.module.NetworkModule;

public class BaseApplication extends Application
{
    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://jsonplaceholder.typicode.com"))
                .build();
    }

    public AppComponent getNetworkComponent() {
        return appComponent;
    }
}
