package com.netimur.firsttask.firstapi.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netimur.firsttask.databinding.FragmentPictureBinding;
import com.netimur.firsttask.firstapi.CatPicContract;
import com.netimur.firsttask.firstapi.presenter.CatPresenter;
import com.squareup.picasso.Picasso;

public class CatPresentFragment extends Fragment implements CatPicContract.View {

    private FragmentPictureBinding binding;
    private CatPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPictureBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new CatPresenter(this);
        binding.buttonFirstFragment.setOnClickListener(view1 -> presenter.onClick(binding.editTextFirstFragment.getText().toString()));
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public FragmentPictureBinding getBinding() {
        return binding;
    }



}