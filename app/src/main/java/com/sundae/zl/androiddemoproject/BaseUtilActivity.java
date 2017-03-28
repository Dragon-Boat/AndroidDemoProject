package com.sundae.zl.androiddemoproject;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sundae.zl.androiddemoproject.util.ViewUtil;

/**
 * Created by @author hzzhoulong
 * on 2017/3/27.
 * # Copyright 2017 netease. All rights reserved.
 */

public class BaseUtilActivity extends AppCompatActivity {
    private boolean mDestroyed;

    protected <E extends View> E $(@IdRes int resId) {
        return ViewUtil.findViewById(this, resId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDestroyed = true;

    }

    public boolean canTouchUi() {
        return !isFinishing() && !mDestroyed;
    }

}
