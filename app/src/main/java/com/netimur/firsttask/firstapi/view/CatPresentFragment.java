package com.netimur.firsttask.firstapi.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.util.Log;
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
    private String IMAGE_KEY = "image";
    private String COMMON_KEY = "COMMON_KEY";

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
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            if (binding.catsImageView.getDrawable() != null) {
                Bitmap imageToSave = drawableToBitmap((Drawable) binding.catsImageView.getDrawable());
                outState.putParcelable(IMAGE_KEY, imageToSave);
            }
        }
        catch (NullPointerException e){

        }

        Log.d(COMMON_KEY, "onSaveInstanceState");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            binding.catsImageView.setImageBitmap(savedInstanceState.getParcelable(IMAGE_KEY));
        }
        Log.d(COMMON_KEY, "onViewCreated");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(COMMON_KEY, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(COMMON_KEY, "onDestroy");
        binding = null;
    }

    @Override
    public FragmentPictureBinding getBinding() {
        return binding;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


}