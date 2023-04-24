package com.vadianastia.nutridata;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NutriData.initHelper(this);
    }
}
