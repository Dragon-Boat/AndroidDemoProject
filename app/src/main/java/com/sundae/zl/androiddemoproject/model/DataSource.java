package com.sundae.zl.androiddemoproject.model;

import android.support.annotation.DrawableRes;

import com.sundae.zl.androiddemoproject.R;

/**
 * Created by @author hzzhoulong
 * on 2017/3/28.
 * # Copyright 2017 netease. All rights reserved.
 */

public class DataSource {
    private volatile static DataSource dataSource;
    private DataSource(){

    }

    public static DataSource get(){
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }
    public int[] getImages() {
        return IMAGES;
    }

    public int[] getImages(int times) {
        int[] result = new int[IMAGES.length * times];
        for (int i = 0; i < result.length; i++) {
            result[i] = IMAGES[(int) (Math.random() * IMAGES.length)];
        }
        return result;
    }

    private static final @DrawableRes int[] IMAGES = new int[]{
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4,
            R.drawable.photo_5,
            R.drawable.photo_6,
            R.drawable.photo_7,
            R.drawable.photo_8,
            R.drawable.photo_9,
            R.drawable.photo_10,
            R.drawable.photo_11,
            R.drawable.photo_12,
            R.drawable.photo_13,
            R.drawable.photo_14,
            R.drawable.photo_15,
            R.drawable.photo_16,
            R.drawable.photo_17,
    };
}
