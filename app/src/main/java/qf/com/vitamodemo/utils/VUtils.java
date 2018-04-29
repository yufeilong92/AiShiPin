package qf.com.vitamodemo.utils;

import android.content.Context;

import com.android.volley.RequestQueue;

import qf.com.vitamodemo.BaseApp;

public class VUtils {

    public static RequestQueue getQueue(Context context) {
        return BaseApp.getQueue(context);
    }
}
