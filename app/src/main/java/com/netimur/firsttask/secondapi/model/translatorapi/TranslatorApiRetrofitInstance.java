package com.netimur.firsttask.secondapi.model.translatorapi;

import com.netimur.firsttask.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslatorApiRetrofitInstance {
    private static TranslatorApi instance;

    private TranslatorApiRetrofitInstance(){
        instance = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_TRANSLATOR_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TranslatorApi.class);
    }
    public static synchronized TranslatorApi getInstance(){
        if(instance ==null){
            new TranslatorApiRetrofitInstance();
        }
        return instance;
    }
}
