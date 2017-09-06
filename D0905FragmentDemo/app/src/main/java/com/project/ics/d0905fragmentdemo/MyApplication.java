package com.project.ics.d0905fragmentdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/9/5.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}
