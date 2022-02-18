package com.netimur.firsttask.secondapi.model.factapi;

import com.netimur.firsttask.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FactApiRetrofitInstance {
    private static FactApi instance;

    private FactApiRetrofitInstance() {
        instance = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_SECOND_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FactApi.class);
    }

    public static synchronized FactApi getInstance() {
        if(instance==null){
            new FactApiRetrofitInstance();
        }
        return instance;
    }

}
