package com.sundae.zl.androiddemoproject.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fivehundredpx.greedolayout.GreedoLayoutSizeCalculator;

/**
 * Created by @author hzzhoulong
 * on 2017/3/28.
 * # Copyright 2017 netease. All rights reserved.
 */

public class GreedoRVAdapter extends RecyclerView.Adapter implements GreedoLayoutSizeCalculator.SizeCalculatorDelegate{
    private int[] mImageResIds = DataSource.get().getImages(5);
    private final double[] mImageAspectRatios = new double[mImageResIds.length];

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        return new GreedoViewHoder(imageView);
    }

    public GreedoRVAdapter(Context context) {
        super();
        calculateImageAspectRatios(context);
    }

    private void calculateImageAspectRatios(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        for (int i = 0; i < mImageResIds.length; i++) {
            BitmapFactory.decodeResource(context.getResources(), mImageResIds[i], options);
            mImageAspectRatios[i] = options.outWidth / (double) options.outHeight;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ImageView) holder.itemView).setImageResource(mImageResIds[position]);
    }

    @Override
    public int getItemCount() {
        return mImageResIds.length;
    }

    @Override
    public double aspectRatioForIndex(int i) {
        if (i >= getItemCount()) {
            return 1.0;
        }
        return mImageAspectRatios[getLoopedIndex(i)];
    }

    private class GreedoViewHoder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public GreedoViewHoder(View view) {
            super(view);
            imageView = ((ImageView) view);
        }
    }
    // Index gets wrapped around <code>Constants.IMAGES.length</code> so we can loop content.
    private int getLoopedIndex(int index) {
        return index % mImageResIds.length; // wrap around
    }
}
