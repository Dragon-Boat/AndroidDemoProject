package com.sundae.zl.androiddemoproject.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.sundae.zl.androiddemoproject.BaseUtilActivity;
import com.sundae.zl.androiddemoproject.R;

public class RecyclerViewDemoActivity extends BaseUtilActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    String[] tabTitles = new String[]{"GreedoLM", "FlexLM", "VirtualLM","CustomLM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        tabLayout = $(R.id.tab_layout);
        viewPager = $(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setLayoutMode(TabLayout.MODE_SCROLLABLE);
        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return GreedoRVFragment.instance();
                }
                if (position == 1) {
                    return FlexRVFragment.instance();
                }
                if (position == 2) {
                    return GreedoRVFragment.instance();
                }
                if (position == 3) {
                    return VLayoutRVFragment.instance();
                }
                return GreedoRVFragment.instance();
            }

            @Override
            public int getCount() {
                return tabTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }
        };
        viewPager.setAdapter(adapter);
    }



    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclerview,menu);
        return true;
    }

}
