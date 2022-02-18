package com.netimur.firsttask.secondapi.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.R;
import com.netimur.firsttask.secondapi.FactsContract;
import com.netimur.firsttask.secondapi.model.factapi.FactApi;
import com.netimur.firsttask.secondapi.model.factapi.FactApiRetrofitInstance;
import com.netimur.firsttask.secondapi.model.factapi.FactRepository;
import com.netimur.firsttask.secondapi.model.translatorapi.TranslatorRepository;

public class FactPresenter implements FactsContract.Presenter {
    private FactsContract.Repository repository;
    private FactsContract.TranslatorContract translatorRepository;
    private FactsContract.View view;
    private MutableLiveData<String> fact = new MutableLiveData<>();
    private MutableLiveData<String> translation = new MutableLiveData<>();

    public FactPresenter(FactsContract.View view) {
        this.view = view;
        this.repository = new FactRepository();
        this.translatorRepository = new TranslatorRepository();
    }

    @Override
    public void onButtonClick() {
        if (connectedToNetwork(view.getContext())) {
            this.fact.setValue("");
            fact = repository.getFact();
        } else
            view.showToast(view.getContext(), view.getContext().getResources().getString(R.string.connection_error));
        this.fact.observe((LifecycleOwner) view, s -> view.showFact(s));

    }

    @Override
    public void onTranslatorButtonClick() {
        if (connectedToNetwork(view.getContext())) {
            if (fact.getValue() != null) {
                this.translation.setValue("");
                translation = translatorRepository.getTranslation(fact.getValue());
            } else
                view.showToast(view.getContext(), view.getContext().getResources().getString(R.string.nothing_to_translate_error));
            this.translation.observe((LifecycleOwner) view, s -> view.showFact(s));

        } else
            view.showToast(view.getContext(), view.getContext().getResources().getString(R.string.connection_error));
    }

    @Override
    public void setSavedFact(String fact) {
        this.fact.setValue(fact);
    }



}
