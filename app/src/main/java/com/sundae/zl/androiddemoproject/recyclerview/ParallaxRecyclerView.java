package com.sundae.zl.androiddemoproject.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.sundae.zl.androiddemoproject.util.ScreenUtil;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class ParallaxRecyclerView extends RecyclerView {
    public ParallaxRecyclerView(Context context) {
        super(context);
    }

    public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setLayoutManager(new LinearLayoutManager(context));

        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = -ScreenUtil.dp2px(10);
            }
        });

        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstPos = layoutManager.findFirstVisibleItemPosition();
                int lasPos = layoutManager.findLastVisibleItemPosition();
                int visibleCount = lasPos - firstPos;
                int elevation = 1;
                for (int i = firstPos - 1; i <= (firstPos + visibleCount) + 1; i++) {
                    View v = layoutManager.findViewByPosition(i);
                    if (v != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            v.setElevation(ScreenUtil.dp2px(elevation));
                            elevation += 5;
                        }
                        float transLationY =v.getTranslationY();
                        if (i > firstPos && transLationY != 0) {
                            v.setTranslationY(0);

                        }
                    }
                }
                View firstView = layoutManager.findViewByPosition(firstPos);
                float firstViewTop = firstView.getTop();
                firstView.setTranslationY(-firstViewTop / 2.0f);
            }
        });
    }

}
