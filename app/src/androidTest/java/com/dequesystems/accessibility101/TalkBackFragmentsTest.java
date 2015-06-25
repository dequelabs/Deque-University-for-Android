package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melinda.kothbauer@deque.com on 6/25/15.
 * Tests the TalkBack story's fragments
 */
public class TalkBackFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private TabHost mTabHost;
    private StoryManager mStoryManager;

    public TalkBackFragmentsTest(){
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
        mStoryManager.setActiveStory(1, mTabHost);

        mTabHost.setCurrentTab(0);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null",  mTabHost.getTabContentView());
        ;
        mTabHost.setCurrentTab(1);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " demos tab is null", mTabHost.getTabContentView());

        mTabHost.setCurrentTab(2);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " advanced tab is null", mTabHost.getTabContentView());
    }

}
