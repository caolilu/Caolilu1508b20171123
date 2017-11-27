package com.example.cll.caolilu1508b20171123;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by cll on 2017/11/23.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
