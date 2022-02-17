package com.netimur.firsttask;

import android.content.Context;
import android.widget.Toast;

public interface ToastShowCapable {
    default void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
