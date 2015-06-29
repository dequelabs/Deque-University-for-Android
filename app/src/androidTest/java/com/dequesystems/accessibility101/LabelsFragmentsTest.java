package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melinda.kothbauer@deque.com on 6/3/15.
 * Tests Labels Story Fragments
 */
public class LabelsFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private StoryManager mStoryManager;
    private TabHost mTabHost;
    private MainActivity mActivity;

    public LabelsFragmentsTest() {
        super(MainActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        assertNotNull("activity is null", mActivity);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);
    }

    @UiThreadTest
    public void testTabs(){
        mStoryManager.setActiveStory(3, mTabHost);

        String tabTitle;

        tabTitle = mActivity.getString(R.string.aac_tab_title_about);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_tab_title_broken);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " broken tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_tab_title_fixed);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " fixed tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));
    }

}
