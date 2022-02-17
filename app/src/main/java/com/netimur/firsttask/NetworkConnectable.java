package com.netimur.firsttask;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public interface NetworkConnectable {
   default boolean connectedToNetwork(Context applicationContext) {
       ConnectivityManager cm = (ConnectivityManager)applicationContext.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo nInfo = cm.getActiveNetworkInfo();
       boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
       return connected;
   }
}
