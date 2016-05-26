package com.dequesystems.accessibility101;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dequesystems.accessibility101.acronym.AcronymAnnouncementAboutFragment;

import java.util.ArrayList;

/**
 * Created by melindakothbauer on 5/26/16.
 */
public class TabViewPager extends FragmentPagerAdapter {

    int tabCount;
    ArrayList<Fragment> mFragments;

    public TabViewPager(FragmentManager fragmentManager, int tabCount, ArrayList<Fragment> fragments) {
        super(fragmentManager);
        this.tabCount = tabCount;
        mFragments = fragments;
}

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : {
                return mFragments.get(0);
            }
            case 1 : {
                return mFragments.get(1);
            }
            case 2 : {
                return mFragments.get(2);
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}