package com.sundae.zl.androiddemoproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerViewDemoActivity extends BaseUtilActivity {
    ViewGroup container;
    List<Fragment> fragmentList = Collections.emptyList();
    private Fragment mCurrentFrament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        container = $(R.id.fragment_container);
        initFragmentList();
        replaceFragment(RecyclerViewFragment.instance());
    }

    private void initFragmentList() {
        fragmentList = new ArrayList<>();
        fragmentList.add(RecyclerViewFragment.instance());
    }

    private void replaceFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mCurrentFrament != null) {
            ft.hide(mCurrentFrament);
        }
        if (!fragment.isAdded()) {
            ft.add(R.id.fragment_container, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewDemoActivity.class);
        context.startActivity(intent);
    }
}
