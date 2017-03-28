package com.sundae.zl.androiddemoproject;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.sundae.zl.androiddemoproject.util.ViewUtil;

/**
 * Created by @author hzzhoulong
 * on 2017/3/27.
 * # Copyright 2017 netease. All rights reserved.
 */

public class BaseUtilFragment extends Fragment {
    public <E extends View> E $(View view, @IdRes int resId) {
        return ViewUtil.findViewById(view, resId);
    }

    /**
     * 是否可以安全的更新fragment的ui
     */
    public boolean canTouchUi() {
        Activity activity = getActivity();
        if (activity == null
                || activity.isFinishing()
                || isDetached()
                || isRemoving()
                || !isAdded()) {
            return false;
        }

        if (activity instanceof BaseUtilActivity) {
            return ((BaseUtilActivity) activity).canTouchUi();
        }

        return activity.isDestroyed();

    }
}
