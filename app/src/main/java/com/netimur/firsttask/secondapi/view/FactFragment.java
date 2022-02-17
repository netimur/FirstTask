package com.netimur.firsttask.secondapi.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.firsttask.databinding.FragmentFactBinding;
import com.netimur.firsttask.secondapi.FactsContract;
import com.netimur.firsttask.secondapi.presenter.FactPresenter;


public class FactFragment extends Fragment implements FactsContract.View, LifecycleOwner {
    private FragmentFactBinding binding;
    private FactsContract.Presenter presenter;
    private final String FACT_KEY = "fact";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        presenter = new FactPresenter(this);

        binding.buttonGetFact.setOnClickListener(view -> presenter.onButtonClick());

        binding.translateButton.setOnClickListener(view -> presenter.onTranslatorButtonClick());

        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FACT_KEY, binding.factTextView.getText().toString());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            binding.factTextView.setText(savedInstanceState.getString(FACT_KEY));
            presenter.setSavedFact(savedInstanceState.getString(FACT_KEY));
        }
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