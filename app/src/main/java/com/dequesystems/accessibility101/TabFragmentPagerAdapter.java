package com.dequesystems.accessibility101;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by melindakothbauer on 5/26/16.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    int tabCount;
    ArrayList<Fragment> mFragments;

    public TabFragmentPagerAdapter(FragmentManager fragmentManager, int tabCount, ArrayList<Fragment> fragments) {
        super(fragmentManager);
        this.tabCount = tabCount;
        mFragments = new ArrayList<>();
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if(position < 0 || position > mFragments.size() - 1) {
            Log.e(this.getClass().getSimpleName(), "Tried to access fragment outside bounds of array list");
            return null;
        }
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public long getItemId(int position) {
        return mFragments.get(position).hashCode();
    }
}