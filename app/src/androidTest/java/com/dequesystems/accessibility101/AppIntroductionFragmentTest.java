package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/*
 * Created by melindakothbauer on 6/2/15.
 */

public class AppIntroductionFragmentTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private static MainActivity mActivity;
    private static TabHost mTabHost;
    private static StoryManager mStoryManager;

    public AppIntroductionFragmentTest(){
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

        for(int i = 0; i < 2; i++){
            mStoryManager.setActiveStory(i, mTabHost); // checks both instances where the introduction is the current story due to the Deque logo being the first item in nav. drawer

            mTabHost.setCurrentTab(0);
            assertNotNull(mStoryManager.getActiveStory().getTitle() + " view is null", mTabHost.getTabContentView());
        }

    }

}
