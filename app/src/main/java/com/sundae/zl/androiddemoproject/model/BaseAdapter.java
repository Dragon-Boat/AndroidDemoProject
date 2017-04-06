package com.sundae.zl.androiddemoproject.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class BaseAdapter extends RecyclerView.Adapter{
    private static final String TAG = "BaseAdapter";
    private int[] mImageResIds = DataSource.get().getImages();
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        count.getAndAdd(1);
        Log.d(TAG, "onCreateViewHolder count: " + count);
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(600,600));

        return new BaseViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).imageView.setImageResource(mImageResIds[position]);

    }

    @Override
    public int getItemCount() {
        return mImageResIds.length;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public BaseViewHolder(ImageView imageView) {
            super(imageView);
            this.imageView = imageView;
        }
    }
}
