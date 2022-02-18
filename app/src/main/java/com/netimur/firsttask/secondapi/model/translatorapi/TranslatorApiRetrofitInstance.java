package com.netimur.firsttask.secondapi.model.translatorapi;

import com.netimur.firsttask.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslatorApiRetrofitInstance {

    private static final TranslatorApiRetrofitInstance instance = new TranslatorApiRetrofitInstance();
    private final TranslatorApi translatorApi;

    private TranslatorApiRetrofitInstance() {
        this.translatorApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_TRANSLATOR_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TranslatorApi.class);
    }

    public static synchronized TranslatorApiRetrofitInstance getInstance() {
        return instance;
    }

    public TranslatorApi getTranslatorApi() {
        return this.translatorApi;
    }

}
