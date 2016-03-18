package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/**
 * Created by melinda.kothbauer@deque.com on 6/25/15.
 * Tests the TalkBack story's fragments
 */
public class TalkBackFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private TabHost mTabHost;
    private StoryManager mStoryManager;

    public TalkBackFragmentsTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        assertNotNull("mActivity is null", mActivity);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);
    }

    @UiThreadTest
    public void testTabs() {
        mStoryManager.setActiveStory(1, mTabHost);

        String tabTitle;

        tabTitle = mActivity.getString(R.string.aac_tab_title_about);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_talkBack_tab_title_demo);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " demos tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

        tabTitle = mActivity.getString(R.string.aac_talkBack_tab_title_advanced);
        assertNotNull(mStoryManager.getActiveStory().getTitle() + " advanced tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));
    }
}
