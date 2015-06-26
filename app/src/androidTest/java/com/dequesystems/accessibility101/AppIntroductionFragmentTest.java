package com.dequesystems.accessibility101;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

/*
 * Created by melinda.kothbauer@deque.com on 6/2/15.
 * Tests Introduction Story fragment
 */

public class AppIntroductionFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private TabHost mTabHost;
    private MainActivity mActivity;
    private StoryManager mStoryManager;

    public AppIntroductionFragmentTest() {
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
            mStoryManager.setActiveStory(0, mTabHost);

            String tabTitle;

            tabTitle = mActivity.getString(R.string.aac_intro_tab_1);
            assertNotNull(mStoryManager.getActiveStory().getTitle() + " about tab is null", mStoryManager.getActiveStory().getTabByTitle(tabTitle));

    }

}
