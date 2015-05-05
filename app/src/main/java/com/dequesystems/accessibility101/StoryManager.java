package com.dequesystems.accessibility101;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import com.dequesystems.accessibility101.contentdescriptions.ContDescAboutFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescBrokenFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescFixedFragment;
import com.dequesystems.accessibility101.introduction.AppIntroductionFragment;
import com.dequesystems.accessibility101.labels.LabelsAboutFragment;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;
import com.dequesystems.accessibility101.labels.LabelsFixedFragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chrismcmeeking on 4/24/15.
 */
public class StoryManager {

    private static final String LOG_TAG = StoryManager.class.getSimpleName();

    List<Story> mStories;

    MainActivity mActivity;

    private Story mActiveStory = null;

    StoryManager(MainActivity activity) {
        mActivity = activity;

        ArrayList<Story> tempList = new ArrayList<>();

        Story tempStory = new Story(mActivity.getString(R.string.aac_intro_title));
        tempStory.addTab(mActivity.getString(R.string.aac_intro_tab_1), new AppIntroductionFragment());
        tempList.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_labels_title));
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), new LabelsAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), new LabelsBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), new LabelsFixedFragment());
        tempList.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_cont_desc_title));
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), ContDescAboutFragment.newInstance("Blarg", "Blargety"));
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), ContDescBrokenFragment.newInstance("Blarg", "BLBLBLB"));
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), ContDescFixedFragment.newInstance("Blarg", "Blarguree"));
        tempList.add(tempStory);

        mStories = tempList;
    }

    public void setActiveStory(int index, TabHost tabHost) {
        mStories.get(index).makeActiveStory(tabHost);
    }

    public Story getActiveStory() {
        return mActiveStory;
    }

    Iterator<Story> getStoryIterator() {
        return mStories.iterator();
    }

    Story getStory(int index) {
        return mStories.get(index);
    }

    class Story {
        static final String TAB_ID = "TAB_ID_";

        final String mTitle;

        ArrayList<Tab> mTabs;

        private Story (String title) {
            mTitle = title;
            mTabs = new ArrayList<>();
        }

        private void addTab(String tabTitle, Fragment content) {
            mTabs.add(new Tab(tabTitle, content));
        }

        private void makeActiveStory(TabHost tabHost) {
            tabHost.clearAllTabs();

            for (Iterator it = this.getTabIterator(); it.hasNext(); ) {
                Story.Tab tab = (Story.Tab)it.next();

                TabHost.TabSpec tabSpec = tabHost.newTabSpec(tab.getTabID());
                tabSpec.setContent(tab);
                tabSpec.setIndicator(tab.getTitle());
                tabHost.addTab(tabSpec);
            }

            StoryManager.this.mActiveStory = this;
        }

        String getTitle() { return mTitle;}

        Tab getTabByTitle(String tabTitle) {

            for (Iterator<Tab> it = mTabs.iterator(); it.hasNext(); ) {
                Tab tab = it.next();
                if (tabTitle == tab.mTitle) {
                    return tab;
                }
            }

            return null;
        }

        Tab getTabByID(String tabId) {

            for (Iterator<Tab> it = mTabs.iterator(); it.hasNext(); ) {
                Tab tab = it.next();
                if (tabId == tab.getTabID()) {
                    return tab;
                }
            }

            return null;
        }

        Iterator<Tab> getTabIterator() {
            return mTabs.iterator();
        }

        private class Tab implements  TabHost.TabContentFactory{

            private View mView = null;

            private final String mTitle;

            private final String mTabID;

            private Fragment mFragment;

            private Tab(String title, Fragment fragment) {
                mFragment = fragment;
                mTitle = title;
                mTabID = Story.this.getTitle().toUpperCase() + "_" + mTitle.toUpperCase() + "_TAB";
            }

            public String getTitle() { return mTitle;}

            public Fragment getFragment() { return mFragment;}

            public String getTabID() { return mTabID;}

            @Override
            public View createTabContent(String tag) {
                Log.v(LOG_TAG, "Creating tab content for tab: " + tag.toString());

                if (mView != null) return mView;

                final int viewId = Math.abs(mTabID.hashCode());

                mView = new RelativeLayout(mActivity);
                mView.setId(viewId);

                FragmentTransaction fragmentTransaction = mActivity.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(viewId, mFragment);
                fragmentTransaction.commit();

                return mView;
            }
        }
    }
}
