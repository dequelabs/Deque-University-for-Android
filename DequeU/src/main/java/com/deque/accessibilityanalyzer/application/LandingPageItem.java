package com.deque.accessibilityanalyzer.application;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.deque.accessibilityanalyzer.R;

public abstract class LandingPageItem {

    private String title;

    protected Context context;

    LandingPageItem(Context context, int title) {
        this.context = context;
        this.title = context.getString(title);
    }

    void commitFragmentTransaction(Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.aac_main_fragment, fragment)
                .addToBackStack("NotLandingFragment")
                .commit();
    }

    public TextView.OnClickListener launch() {
        return null;
    }

    public String getTitle() {
        return title;
    }
}
