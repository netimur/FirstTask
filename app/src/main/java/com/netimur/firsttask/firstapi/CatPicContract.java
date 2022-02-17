package com.netimur.firsttask.firstapi;


import android.content.Context;

import com.netimur.firsttask.NetworkConnectable;
import com.netimur.firsttask.ToastShowCapable;
import com.netimur.firsttask.databinding.FragmentPictureBinding;

public interface CatPicContract {
    interface View extends ToastShowCapable {
        FragmentPictureBinding getBinding();
        Context getContext();

    }

    interface Presenter extends NetworkConnectable {
        boolean lengthIsGreaterThanZero(String message);
        void loadPictureWithMessage(String message);
        void onClick(String message);
    }

}
