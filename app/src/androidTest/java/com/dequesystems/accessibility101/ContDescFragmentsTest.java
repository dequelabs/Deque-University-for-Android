package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melindakothbauer on 6/5/15.
 */
public class ContDescFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private TabHost mTabHost;
    private StoryManager mStoryManager;

    public ContDescFragmentsTest(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();

        MainActivity mActivity = getActivity();
        assertNotNull("mActivity is null", mActivity);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);
    }

    @UiThreadTest
    public void testTabs(){
        mStoryManager.setActiveStory(4, mTabHost);

        mTabHost.setCurrentTab(0);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null", mTabHost.getTabContentView());

        mTabHost.setCurrentTab(1);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " broken tab is null", mTabHost.getTabContentView());

        mTabHost.setCurrentTab(2);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " fixed tab is null", mTabHost.getTabContentView());
    }

}
