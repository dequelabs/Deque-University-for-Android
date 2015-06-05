package com.dequesystems.accessibility101;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.dequesystems.accessibility101.labels.LabelsAboutFragment;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;
import com.dequesystems.accessibility101.labels.LabelsFixedFragment;

import org.w3c.dom.DOMStringList;

/**
 * Created by melindakothbauer on 6/3/15.
 */
public class LabelsFragmentsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static Intent mLaunchIntent;
    private static Fragment mFragment;
    private static MainActivity mActivity;
    private static FragmentTransaction mTransaction;
    private static StoryManager mStoryManager;
    private static TabHost mTabHost;

    public LabelsFragmentsTest() {
        super(MainActivity.class);
    }

    public LabelsFragmentsTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();

        mActivity =  getActivity();
        assertNotNull("activity is null", mActivity);

        mStoryManager = mActivity.getStoryManager();
        assertNotNull("mStoryManager is null", mStoryManager);

        mTabHost = mActivity.getTabHost();
        assertNotNull("mTabHost is null", mTabHost);

//        mFragment = new LabelsAboutFragment();
//        mTransaction = mActivity.getFragmentManager().beginTransaction();
//        addFragment(mFragment, "AboutTabFragment", R.id.aac_labels_about_layout, mTransaction);


        //mFragment = startFragment(new LabelsAboutFragment());
       // assertNotNull("mFragment is null", mFragment);

    }

//    private Fragment startFragment(Fragment fragment) {
//        startActivity(mLaunchIntent, null, null);
//        FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
//        transaction.add(R.id.activity_test_fragment_linearlayout, fragment, "tag");
//        transaction.commit();
//        getInstrumentation().waitForIdleSync();
//        Fragment frag = getActivity().getFragmentManager().findFragmentByTag("tag");
//        return frag;
//    }
//
//    private void addFragment(Fragment fragment, String fragName, int viewID, FragmentTransaction transaction){
//        transaction.add(fragment, fragName);
//        transaction.commit();
//        getInstrumentation().waitForIdleSync();
//        assertNotNull(fragName + " is null", mFragment);
//        assertNotNull(fragName + " view is null", mActivity.findViewById(viewID));
//    }

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
