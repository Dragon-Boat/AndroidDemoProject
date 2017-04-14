package com.sundae.zl.androiddemoproject.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class BaseAdapter extends RecyclerView.Adapter{
    private static final String TAG = "BaseAdapter";
    private int[] mImageResIds = DataSource.get().getImages();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: " );
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300,300));

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
