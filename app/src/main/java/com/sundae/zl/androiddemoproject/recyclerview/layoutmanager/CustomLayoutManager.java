package com.sundae.zl.androiddemoproject.recyclerview.layoutmanager;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class CustomLayoutManager extends RecyclerView.LayoutManager {

    int verticalScrollOffset;
    int totalHeight;
    private SparseArray<Rect> allItemFrames = new SparseArray<>();
    private SparseBooleanArray hasAttachedItems = new SparseBooleanArray();

    public CustomLayoutManager() {
        super();
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
//定义竖直方向的偏移量
        int offsetY = 0;
        int offsetX = 0;
        totalHeight = 0;
        int childCount = getItemCount();
        if (childCount <= 0) {
            return;
        }

        for (int i = 0; i < childCount; i++) {
            //这里就是从缓存里面取出
            View view = recycler.getViewForPosition(i);
            //将View加入到RecyclerView中
            addView(view);
            //对子View进行测量
            measureChildWithMargins(view, 0, 0);
            //把宽高拿到，宽高都是包含ItemDecorate的尺寸
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            width = width / 2 + 1;
            height = height / 2 + 1;
            if (width + offsetX >= getWidth()) {
                offsetX = 0;
            }
            Rect frame = allItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            frame.set(offsetX, offsetY, offsetX + width, offsetY + height);
            allItemFrames.put(i, frame);
            hasAttachedItems.put(i, false);
            //最后，将View布局
//            layoutDecorated(view, offsetX, offsetY, offsetX + width, offsetY + height);
            totalHeight += height;
            offsetY += height;
            offsetX += width;
        }
        totalHeight = Math.max(totalHeight, getVerticalSpace());
        recyclerAndFillItems(recycler, state);
    }

    private void recyclerAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        Rect displayFrame = new Rect(0, verticalScrollOffset, getHorizontalSpace(), verticalScrollOffset + getVerticalSpace());
        Rect childFrame = new Rect();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            childFrame.left = getDecoratedLeft(child);
            childFrame.right = getDecoratedRight(child);
            childFrame.top = getDecoratedTop(child);
            childFrame.bottom = getDecoratedBottom(child);

            if (!Rect.intersects(displayFrame, childFrame)) {
                removeAndRecycleView(child, recycler);
            }
        }

        for (int i = 0; i < getItemCount(); i++) {

            if (Rect.intersects(displayFrame, allItemFrames.get(i))) {

                View scrap = recycler.getViewForPosition(i);
                measureChildWithMargins(scrap, 0, 0);
                addView(scrap);

                Rect frame = allItemFrames.get(i);
                //将这个item布局出来
                layoutDecorated(scrap,
                        frame.left,
                        frame.top - verticalScrollOffset,
                        frame.right,
                        frame.bottom - verticalScrollOffset);

            }
        }

    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int travel = dy;

        if (verticalScrollOffset + dy <= 0) {
            travel = -verticalScrollOffset;
        } else if (verticalScrollOffset + dy > totalHeight - getVerticalSpace()) {
            travel = totalHeight - getVerticalSpace() - verticalScrollOffset;
        }
        verticalScrollOffset += travel;
        offsetChildrenVertical(-travel);
        recyclerAndFillItems(recycler, state);
        Log.d("CustomLayoutManager", " childView count: " + getChildCount());
        return travel;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }

    public int getHorizontalSpace() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }
}
