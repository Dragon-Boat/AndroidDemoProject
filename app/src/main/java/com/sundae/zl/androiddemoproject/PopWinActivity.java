package com.sundae.zl.androiddemoproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by @author hzzhoulong
 * on 2017/3/31.
 * # Copyright 2017 netease. All rights reserved.
 */

public class PopWinActivity extends BaseUtilActivity {
    Button button;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwin_activity);
        button = $(R.id.showPopWin);
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.popwin_content, null, false));
        popupWindow.setAnimationStyle(R.style.PopWinAnim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(button);
                }
            }
        });

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PopWinActivity.class);
        context.startActivity(intent);
    }
}
