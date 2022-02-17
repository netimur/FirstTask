package com.netimur.firsttask.secondapi.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.firsttask.secondapi.SecondApiContract;
import com.netimur.firsttask.databinding.FragmentSecondApiBinding;
import com.netimur.firsttask.secondapi.presenter.SecondFragmentPresenter;


public class SecondApiFragment extends Fragment implements SecondApiContract.View, LifecycleOwner {
    private FragmentSecondApiBinding binding;
    private SecondApiContract.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondApiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        presenter = new SecondFragmentPresenter(this);

        binding.buttonGetFact.setOnClickListener(view -> {
            presenter.onButtonClick();
        });

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void showFact(String fact) {
        binding.factTextView.setText(fact);
    }
}