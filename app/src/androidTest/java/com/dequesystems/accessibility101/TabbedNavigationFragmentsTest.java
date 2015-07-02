package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melindakothbauer on 6/17/15.
 */
public class TabbedNavigationFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private TabHost mTabHost;
    private StoryManager mStoryManager;
    private MainActivity mActivity;

    public TabbedNavigationFragmentsTest(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();

        mActivity = getActivity();
        assertNotNull("mActivity is null", mActivity);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);
    }

    @UiThreadTest
    public void testTabs(){
        mStoryManager.setActiveStory(6, mTabHost);

        String tabTitle;

        tabTitle = mActivity.getString(R.string.aac_tab_title_about);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_tab_title_broken);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " broken tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_tab_title_fixed);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " fixed tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));
    }

}
