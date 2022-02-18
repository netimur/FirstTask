package com.netimur.firsttask.secondapi.model.translatorapi

import com.netimur.firsttask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TranslatorApiRetrofitInstance {
    val retrofit: TranslatorApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_TRANSLATOR_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslatorApi::class.java)
    }
}