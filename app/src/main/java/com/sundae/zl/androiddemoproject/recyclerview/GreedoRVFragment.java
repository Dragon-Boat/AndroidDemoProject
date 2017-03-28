package com.sundae.zl.androiddemoproject.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fivehundredpx.greedolayout.GreedoLayoutManager;
import com.fivehundredpx.greedolayout.GreedoSpacingItemDecoration;
import com.sundae.zl.androiddemoproject.BaseUtilFragment;
import com.sundae.zl.androiddemoproject.R;
import com.sundae.zl.androiddemoproject.model.GreedoRVAdapter;

/**
 * Created by @author hzzhoulong
 * on 2017/3/27.
 * # Copyright 2017 netease. All rights reserved.
 */

public class GreedoRVFragment extends BaseUtilFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recyclerview,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = $(view, R.id.recycleview);
        GreedoRVAdapter adapter = new GreedoRVAdapter(getContext());
        GreedoLayoutManager layoutManager = new GreedoLayoutManager(adapter);
        layoutManager.setMaxRowHeight(300);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GreedoSpacingItemDecoration(8));
        recyclerView.setAdapter(adapter);
    }

    public static Fragment instance() {
        return new GreedoRVFragment();
    }
}
