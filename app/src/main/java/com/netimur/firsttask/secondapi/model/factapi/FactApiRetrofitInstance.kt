package com.netimur.firsttask.secondapi.model.factapi

import com.netimur.firsttask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FactApiRetrofitInstance {
    val RETROFIT: FactApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_SECOND_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FactApi::class.java)
    }
}