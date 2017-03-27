package com.sundae.zl.androiddemoproject.util;

import android.app.Activity;
import android.view.View;

/**
 * Created by @author hzzhoulong
 * on 2017/3/27.
 * # Copyright 2017 netease. All rights reserved.
 */

@SuppressWarnings("unchecked")
public class ViewUtil {
    public static <E extends View> E findViewById(Activity activity, int resId) {
        return (E) activity.findViewById(resId);
    }
    public static <E extends View> E findViewById(View view, int resId) {
        return (E) view.findViewById(resId);
    }
}
