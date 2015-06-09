package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melindakothbauer on 6/3/15.
 */
public class LabelsFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static StoryManager mStoryManager;
    private static TabHost mTabHost;

    public LabelsFragmentsTest() {
        super(MainActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();

        MainActivity mActivity = getActivity();
        assertNotNull("activity is null", mActivity);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);
    }

    @UiThreadTest
    public void testTabs(){

        mStoryManager.setActiveStory(3, mTabHost);

        mTabHost.setCurrentTab(0);
        assertNotNull(mStoryManager.getActiveStory().getTitle()+ " about tab is null", mTabHost.getTabContentView());

        mTabHost.setCurrentTab(1);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " broken tab is null", mTabHost.getTabContentView());

        mTabHost.setCurrentTab(2);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " fixed tab is null", mTabHost.getTabContentView());

    }

}
