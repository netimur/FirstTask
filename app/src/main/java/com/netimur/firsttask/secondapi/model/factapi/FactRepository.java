package com.netimur.firsttask.secondapi.model.factapi;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.secondapi.FactsContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactRepository implements FactsContract.Repository {

    private MutableLiveData<String> fact = new MutableLiveData<>();

    private Call<CatFact> getFactFromServer() {
        return FactApiRetrofitInstance.getInstance().getFactApi().getFact();
    }

    private void parseResponse(Call<CatFact> response) {
        response.enqueue(new Callback<CatFact>() {
            @Override
            public void onResponse(@NonNull Call<CatFact> call, @NonNull Response<CatFact> response) {
                assert response.body() != null;
                fact.setValue(response.body().getFact());
            }

            @Override
            public void onFailure(@NonNull Call<CatFact> call, @NonNull Throwable t) {
            }

        });
    }

    public MutableLiveData<String> getFact() {
        parseResponse(getFactFromServer());
        return fact;
    }
}
