package com.sundae.zl.androiddemoproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

public class FActivity extends BaseUtilActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, FActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment,menu);
        return true;
    }

    private void replaceFragment(Fragment fragment) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_flex_layout) {

        }
        return super.onOptionsItemSelected(item);
    }
}
