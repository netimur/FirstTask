package com.netimur.firsttask.secondapi.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.netimur.firsttask.R;
import com.netimur.firsttask.secondapi.SecondApiContract;
import com.netimur.firsttask.secondapi.model.Repository;

public class SecondFragmentPresenter implements SecondApiContract.Presenter {
    private SecondApiContract.Repository repository;
    private SecondApiContract.View view;
    private MutableLiveData<String> fact = new MutableLiveData<>();

    public SecondFragmentPresenter(SecondApiContract.View view) {
        this.view = view;
        this.repository = new Repository();
    }

    @Override
    public void onButtonClick() {
        Runnable runnable = () -> {
                fact = repository.getFact();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> fact.observe((LifecycleOwner) view, s -> view.showFact(fact.getValue())));


        };
        if(connectedToNetwork(view.getContext())){
            Thread thread = new Thread(runnable);
            thread.start();
        }
        else
            view.showToast(view.getContext(), view.getContext().getResources().getString(R.string.connection_error));

    }



}
