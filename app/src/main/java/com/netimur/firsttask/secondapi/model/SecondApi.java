package com.netimur.firsttask.secondapi.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SecondApi {

    @GET("fact")
    Call<CatFact> getFact();

}
