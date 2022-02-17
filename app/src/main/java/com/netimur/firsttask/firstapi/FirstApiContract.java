package com.netimur.firsttask.firstapi;


import android.content.Context;

import com.netimur.firsttask.NetworkConnectable;
import com.netimur.firsttask.ToastShowCapable;
import com.netimur.firsttask.databinding.FragmentFirstApiBinding;

public interface FirstApiContract {
    interface View extends ToastShowCapable {
        FragmentFirstApiBinding getBinding();
        Context getContext();

    }

    interface Presenter extends NetworkConnectable {
        boolean lengthIsGreaterThanZero(String message);
        void loadPictureWithMessage(String message);
        void onClick(String message);
    }

}
