package com.example.draggerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.draggerex.api.Api;
import com.example.draggerex.entity.entity_module;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Inject
    Retrofit retrofit;
    private Api todoApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BaseApplication)getApplication()).getNetworkComponent().inject(this);

        todoApi =retrofit.create(Api.class);
        todoApi.getTodo(1).enqueue(new Callback<entity_module>() {
            @Override
            public void onResponse(Call<entity_module> call, Response<entity_module> response) {
                Log.d("Tag", "onResponse: "+response.body().getTitle());
//                textViewTitle.setText(response.body().getTitle());
//                textViewCompleted.setText(String.valueOf(response.body().isCompleted()));
            }

            @Override
            public void onFailure(Call<entity_module> call, Throwable t) {
                Log.d("Tag", "onFailure: "+t.getMessage());
            }
        });
    }
}