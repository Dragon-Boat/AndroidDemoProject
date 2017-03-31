package com.sundae.zl.androiddemoproject;

import android.app.Application;
import android.content.Context;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class ZApplication extends Application {
    private static ZApplication instance;

    public static ZApplication getInstance() {
        if (instance == null) {
            throw new RuntimeException("MoneyMasterApplication not created");
        }
        return instance;
    }
    public static Context getAppContext() {
        return getInstance().getApplicationContext();
    }
}
