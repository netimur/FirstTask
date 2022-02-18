package com.netimur.firsttask.secondapi.model.translatorapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TranslatorApi {
    @POST("translate")
    Call<Translation> translateText(@Body TranslatorRequestBody body);
}
