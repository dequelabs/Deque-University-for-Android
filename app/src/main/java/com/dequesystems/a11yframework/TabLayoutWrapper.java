package com.dequesystems.a11yframework;

import android.support.design.widget.*;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;

/**
 * Created by melindakothbauer on 5/25/16.
 */
public class TabLayoutWrapper {

    private TabLayout mTabLayout;

    public TabLayoutWrapper(TabLayout tabLayout) {
        mTabLayout = tabLayout;
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    public void setContentDescriptions() {
        String contentDescription;

        int tabCount = mTabLayout.getTabCount();
        int tabNumber;

        for (tabNumber = 0; tabNumber < tabCount; tabNumber++) {
            contentDescription = mTabLayout.getTabAt(tabNumber).getText() + ", tab " + (tabNumber + 1) + " of " + tabCount;
            if (tabNumber == mTabLayout.getSelectedTabPosition()) {
                contentDescription = contentDescription + " , selected";
            }
            mTabLayout.getTabAt(tabNumber).setContentDescription(contentDescription);
        }
    }

    public void clearTabs() {
        mTabLayout.removeAllTabs();
    }
}
