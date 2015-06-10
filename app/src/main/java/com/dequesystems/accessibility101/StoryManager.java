package com.dequesystems.accessibility101;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.dequesystems.accessibility101.contentdescriptions.ContDescAboutFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescBrokenFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescFixedFragment;
import com.dequesystems.accessibility101.edittexts.EditTextAboutFragment;
import com.dequesystems.accessibility101.edittexts.EditTextBrokenFragment;
import com.dequesystems.accessibility101.edittexts.EditTextFixedFragment;
import com.dequesystems.accessibility101.introduction.AppIntroductionFragment;
import com.dequesystems.accessibility101.labels.LabelsAboutFragment;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;
import com.dequesystems.accessibility101.labels.LabelsFixedFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationAboutFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationBrokenFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationFixedFragment;
import com.dequesystems.accessibility101.talkbacksimulation.TalkBackSimulationFragment;

import java.util.ArrayList;

/**
 * Created by chrismcmeeking on 4/24/15.
 */
public class StoryManager extends ArrayAdapter<StoryManager.Story> {

    private static final String LOG_TAG = StoryManager.class.getSimpleName();

    MainActivity mActivity;

    private Story mActiveStory = null;

    StoryManager(MainActivity activity) {
        super(activity, 0, /*objects*/new ArrayList<Story>());

        mActivity = activity;

        Story tempStory = new Story(mActivity.getString(R.string.aac_intro_title), false);
        tempStory.addTab(mActivity.getString(R.string.aac_intro_tab_1), R.drawable.aac_about_icon, new AppIntroductionFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_talkBack_sim_title), false);
        tempStory.addTab(mActivity.getString(R.string.aac_talkBack_sim_title), R.drawable.aac_non_sighted_icon, new TalkBackSimulationFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_separator_heading_title), false);
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_labels_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new LabelsAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new LabelsBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new LabelsFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_cont_desc_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new ContDescAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new ContDescBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new ContDescFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_edit_text_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new EditTextAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new EditTextBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new EditTextFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_tab_nav_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new TabbedNavigationAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new TabbedNavigationBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new TabbedNavigationFixedFragment());
        this.add(tempStory);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LinearLayout navDrawerCellLayout = (LinearLayout) mActivity.getLayoutInflater().inflate(R.layout.navigation_drawer_cell, null);

        TextView textView = (TextView) navDrawerCellLayout.findViewById(R.id.aac_navigation_drawer_cell_text_view);
        textView.setText(this.getItem(position).getTitle());

        ImageView imageView = (ImageView) navDrawerCellLayout.findViewById(R.id.aac_navigation_drawer_cell_image_view);

        String text = textView.getText().toString();
        int tabCount = 0;
        int tabNumber = 0;

        if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_intro_title))){
            imageView.setImageResource(R.drawable.aac_intro_icon);
            tabNumber = 1;
            tabCount = 2;
        }else if(text.equalsIgnoreCase(mActivity.getString(R.string.aac_talkBack_sim_title))){
            imageView.setImageResource(R.drawable.aac_non_sighted_icon);
            tabNumber = 2;
            tabCount = 2;
        }else if(text.equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title))){
            imageView.setVisibility(View.GONE);
            textView.setTextAppearance(getContext(), R.style.AACTextAppearance_navigation_drawer_heading);
        }else if(text.equalsIgnoreCase(mActivity.getString(R.string.aac_labels_title))){
            imageView.setImageResource(R.drawable.aac_labels_icon);
            tabNumber = 1;
            tabCount = 3;
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_cont_desc_title))){
            imageView.setImageResource(R.drawable.aac_cont_desc_icon);
            tabNumber = 2;
            tabCount = 3;
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_edit_text_title))){
            imageView.setImageResource(R.drawable.aac_edit_text_icon);
            tabNumber = 3;
            tabCount = 3;
        }

        if (!text.equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title))){
            navDrawerCellLayout.setContentDescription(text + ", tab " + tabNumber + " of " + tabCount);
        }else{
            navDrawerCellLayout.setContentDescription(text);

        }

        return navDrawerCellLayout;
    }

    @Override
    public boolean isEnabled(int position){
        if(this.getItem(position).getTitle().toString().equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title))){
            return false;
        }
        return true;
    }

    public void setActiveStory(int index, TabHost tabHost) {
        this.getItem(index).makeActiveStory(tabHost);
    }

    public Story getActiveStory() {
        return mActiveStory;
    }

    Story getStory(int index) {
        return getItem(index);
    }

    class Story {
        static final String TAB_ID = "TAB_ID_";

        final boolean mTabBarVisible;

        final String mTitle;

        ArrayList<Tab> mTabs;

        private Story (String title, boolean tabBarVisible) {
            mTitle = title;
            mTabBarVisible = tabBarVisible;
            mTabs = new ArrayList<>();
        }

        private void addTab(String tabTitle, int imageResource, Fragment content) {
            mTabs.add(new Tab(tabTitle, imageResource, content));
        }

        private void makeActiveStory(TabHost tabHost) {
            tabHost.clearAllTabs();

            if (mTabBarVisible) {
                tabHost.getTabWidget().setVisibility(View.VISIBLE);
            } else {
                tabHost.getTabWidget().setVisibility(View.GONE);
            }

            for (int i = 0; i < mTabs.size(); i++) {
                Story.Tab tab = mTabs.get(i);

                TabHost.TabSpec tabSpec = tabHost.newTabSpec(tab.getTabID());
                tabSpec.setContent(tab);

                View view = mActivity.getLayoutInflater().inflate(R.layout.tab_layout, null);

                TextView textView = (TextView) view.findViewById(R.id.aac_tab_title);
                textView.setText(tab.getTitle());

                ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_image);

                if (tab.getTitle().equalsIgnoreCase(mActivity.getString(R.string.aac_tab_title_about))) {
                    imageView.setImageResource(R.drawable.aac_about_icon);
                }else if(tab.getTitle().equalsIgnoreCase(mActivity.getString(R.string.aac_tab_title_broken))){
                    imageView.setImageResource(R.drawable.aac_broken_icon);
                }else if(tab.getTitle().equalsIgnoreCase(mActivity.getString(R.string.aac_tab_title_fixed))){
                    imageView.setImageResource(R.drawable.aac_fixed_icon);
                }

                ColorFilter overlayColor = new PorterDuffColorFilter(mActivity.getResources().getColor(R.color.aac_tab_bar_dimmed), PorterDuff.Mode.SRC_IN);
                imageView.setColorFilter(overlayColor);

                tabSpec.setIndicator(view);
                tabHost.addTab(tabSpec);
            }

            StoryManager.this.mActiveStory = this;
        }

        String getTitle() { return mTitle;}

        Tab getTabByTitle(String tabTitle) {

            for (int i = 0; i < mTabs.size(); i++ ) {
                Tab tab = mTabs.get(i);

                if (tabTitle == tab.mTitle) {
                    return tab;
                }
            }

            return null;
        }

        Tab getTabByID(String tabId) {

            for (int i = 0; i < mTabs.size(); i++) {
                Tab tab =  mTabs.get(i);

                if (tabId == tab.getTabID()) {
                    return tab;
                }
            }

            return null;
        }

        private class Tab implements  TabHost.TabContentFactory{

            private View mView = null;

            private final String mTitle;

            private final String mTabID;

            private Fragment mFragment;

            private final int mImageResource;

            private Tab(String title, int imageResource, Fragment fragment) {
                mFragment = fragment;
                mTitle = title;
                mTabID = Story.this.getTitle().toUpperCase() + "_" + mTitle.toUpperCase() + "_TAB";
                mImageResource = imageResource;
            }

            public String getTitle() { return mTitle;}

            public Fragment getFragment() { return mFragment;}

            public String getTabID() { return mTabID;}

            public int getImageResource() { return mImageResource;}

            @Override
            public View createTabContent(String tag) {
                Log.v(LOG_TAG, "Creating tab content for tab: " + tag.toString());

                if (mView != null) return mView;

                mView = new RelativeLayout(mActivity);
                mView.setId(Math.abs(mTabID.hashCode()));

                FragmentTransaction fragmentTransaction = mActivity.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(mView.getId(), mFragment, tag);
                fragmentTransaction.commit();

                return mView;
            }
        }
    }
}
