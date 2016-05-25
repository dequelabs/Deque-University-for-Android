package com.dequesystems.a11yframework;

import android.support.design.widget.*;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;

/**
 * Created by melindakothbauer on 5/25/16.
 */
public class TabLayoutWrapper {

    private ArrayList<TabLayout.Tab> mTabs;
    private TabLayout mTabLayout;

    public TabLayoutWrapper(TabLayout tabLayout) {
        mTabs = new ArrayList<>();
        mTabLayout = tabLayout;
    }

    public TabLayout.Tab addTab(TabLayout.Tab tab) {
        mTabs.add(tab);
        //mTabLayout.addTab(tab);
        setContentDescriptions();

        return tab;
    }

    public TabLayout.Tab getTabAt(int position) {
        return mTabs.get(position);
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    public void setContentDescriptions() {
        String contentDescription;

        int tabCount = mTabLayout.getTabCount();
        int tabNumber;

        for (tabNumber = 0; tabNumber < tabCount; tabNumber++) {
            contentDescription = mTabs.get(tabNumber).getText() + ", tab " + (tabNumber + 1) + " of " + tabCount;
            if (tabNumber == mTabLayout.getSelectedTabPosition()) {
                contentDescription = contentDescription + " , selected";
            }
            mTabs.get(tabNumber).setContentDescription(contentDescription);
        }
    }

    public void clearTabs() {
        mTabLayout.removeAllTabs();
    }
}
