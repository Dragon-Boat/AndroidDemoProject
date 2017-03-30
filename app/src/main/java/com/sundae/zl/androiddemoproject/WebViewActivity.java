package com.sundae.zl.androiddemoproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by @author hzzhoulong
 * on 2017/3/30.
 * # Copyright 2017 netease. All rights reserved.
 */

public class WebViewActivity extends BaseUtilActivity {
    public static void start(Context context) {
        Intent intent = new Intent(context, WebViewActivity.class);
        context.startActivity(intent);
    }

    ViewGroup rootView;
    EditText editText;
    String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contanier);
        initView();
    }
    WebView webView;
    private void initView() {
        rootView = $(R.id.container);
        webView = $(R.id.web_view);
        editText = $(R.id.url_edit);
        Button button = $(R.id.load_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    url = editText.getText().toString();
                } else {
                    url = "http://www.google.com";
                }
                webView.loadUrl(url);
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
