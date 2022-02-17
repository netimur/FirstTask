package com.netimur.firsttask.secondapi;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.NetworkConnectable;
import com.netimur.firsttask.ToastShowCapable;

public interface FactsContract {
    interface View extends ToastShowCapable {
        void showFact(String fact);
        Context getContext();

    }

    interface Presenter extends NetworkConnectable {
        void onButtonClick();
        void onTranslatorButtonClick();
        void setSavedFact(String fact);
    }

    interface Repository{
        MutableLiveData<String> getFact();
    }

    interface TranslatorContract {
        MutableLiveData<String> getTranslation(String message);
    }
}
