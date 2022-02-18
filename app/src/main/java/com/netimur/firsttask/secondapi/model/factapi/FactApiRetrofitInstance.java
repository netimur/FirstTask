package com.netimur.firsttask.secondapi.model.factapi;

import com.netimur.firsttask.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FactApiRetrofitInstance {

    private static final FactApiRetrofitInstance instance = new FactApiRetrofitInstance();
    private final FactApi factApi;

    private FactApiRetrofitInstance() {
        this.factApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_SECOND_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FactApi.class);
    }

    public static FactApiRetrofitInstance getInstance() {
        return instance;
    }

    public FactApi getFactApi() {
        return this.factApi;
    }
}
