package com.netimur.firsttask.secondapi;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.netimur.firsttask.NetworkConnectable;
import com.netimur.firsttask.ToastShowCapable;

public interface SecondApiContract {
    interface View extends ToastShowCapable {
        void showFact(String fact);
        Context getContext();

    }

    interface Presenter extends NetworkConnectable {
        void onButtonClick();

    }

    interface Repository{
        MutableLiveData getFact();
    }
}
