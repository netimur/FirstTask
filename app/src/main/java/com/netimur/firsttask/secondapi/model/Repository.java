package com.netimur.firsttask.secondapi.model;

import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.secondapi.SecondApiContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements SecondApiContract.Repository {

    private MutableLiveData<String> fact = new MutableLiveData<>();

    private Call<CatFact> getFactFromServer() {
        Call<CatFact> response = SecondApiRetrofitInstance.INSTANCE.getRetrofit().getFact();
        return response;
    }

    public void parseResponse(Call<CatFact> response) {
        response.enqueue(new Callback<CatFact>() {
            @Override
            public void onResponse(Call<CatFact> call, Response<CatFact> response) {
                assert response.body() != null;
                fact.setValue(response.body().fact);
            }

            @Override
            public void onFailure(Call<CatFact> call, Throwable t) {
            }

        });


    }

    public MutableLiveData<String> getFact() {
        parseResponse(getFactFromServer());
        return fact;
    }


}
