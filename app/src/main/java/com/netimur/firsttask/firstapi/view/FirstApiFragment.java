package com.netimur.firsttask.firstapi.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.netimur.firsttask.R;
import com.netimur.firsttask.databinding.FragmentFirstApiBinding;
import com.netimur.firsttask.firstapi.FirstApiContract;
import com.netimur.firsttask.firstapi.presenter.FirstApiPresenter;
import com.netimur.firsttask.utils.Constants;
import com.squareup.picasso.Picasso;

public class FirstApiFragment extends Fragment implements FirstApiContract.View {

    private FragmentFirstApiBinding binding;
    private FirstApiPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstApiBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new FirstApiPresenter(this);
        binding.buttonFirstFragment.setOnClickListener(view1 -> {
            presenter.onClick(binding.editTextFirstFragment.getText().toString());
        });
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public FragmentFirstApiBinding getBinding() {
        return binding;
    }



}