package com.sundae.zl.androiddemoproject.model;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.flexbox.FlexboxLayoutManager;

/**
 * Created by @author hzzhoulong
 * on 2017/3/28.
 * # Copyright 2017 netease. All rights reserved.
 */

public class FlexRVAdapter extends RecyclerView.Adapter {
    private int[] mImageResIds = DataSource.get().getImages(4);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new FlexboxLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,200));

        return new FlexViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FlexViewHolder) holder).imageView.setImageResource(mImageResIds[position]);
        ViewGroup.LayoutParams lp = ((FlexViewHolder) holder).imageView.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxlp = ((FlexboxLayoutManager.LayoutParams) lp);
//            flexboxlp.setFlexGrow(1.0f);
        }
    }

    @Override
    public int getItemCount() {
        return mImageResIds.length;
    }

    class FlexViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public FlexViewHolder(ImageView imageView) {
            super(imageView);
            this.imageView = imageView;
        }
    }
}
