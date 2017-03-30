package com.sundae.zl.androiddemoproject.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundae.zl.androiddemoproject.BaseUtilFragment;
import com.sundae.zl.androiddemoproject.R;
import com.sundae.zl.androiddemoproject.model.BaseAdapter;
import com.sundae.zl.androiddemoproject.recyclerview.layoutmanager.CustomLayoutManager;

/**
 * Created by @author hzzhoulong
 * on 2017/3/28.
 * # Copyright 2017 netease. All rights reserved.
 */

public class VLayoutRVFragment extends BaseUtilFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recyclerview,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = $(view, R.id.recycleview);
        CustomLayoutManager layoutManager = new CustomLayoutManager();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new BaseAdapter());
    }

    public static Fragment instance() {
        return new VLayoutRVFragment();
    }
}
