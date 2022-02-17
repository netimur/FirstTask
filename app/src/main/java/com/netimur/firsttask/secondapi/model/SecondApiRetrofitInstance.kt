package com.netimur.firsttask.secondapi.model

import com.netimur.firsttask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SecondApiRetrofitInstance {
    val retrofit: SecondApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_SECOND_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SecondApi::class.java)
    }
}