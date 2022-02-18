package com.netimur.firsttask.secondapi.model.translatorapi;

import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.secondapi.FactsContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslatorRepository implements FactsContract.TranslatorContract{

    private MutableLiveData<String> translation = new MutableLiveData<>();

    private void translateText(String message) {
        if (message!=null){
            Call<Translation> translationResponse =
                    TranslatorApiRetrofitInstance
                    .getInstance()
                    .translateText(new TranslatorRequestBody(message));
            translationResponse.enqueue(new Callback<Translation>() {
                @Override
                public void onResponse(Call<Translation> call, Response<Translation> response) {
                    assert response.body() != null;
                    translation.setValue(response.body().translatedText);
                }

                @Override
                public void onFailure(Call<Translation> call, Throwable t) {

                }
            });
        }

    }

    @Override
    public MutableLiveData<String> getTranslation(String message) {
        translateText(message);
        return this.translation;
    }

}
