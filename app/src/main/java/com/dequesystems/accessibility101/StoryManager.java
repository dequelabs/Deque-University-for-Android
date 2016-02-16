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

import com.dequesystems.a11yframework.TabLayout;
import com.dequesystems.accessibility101.acronym.AcronymAnnouncementAboutFragment;
import com.dequesystems.accessibility101.acronym.AcronymAnnouncementBrokenFragment;
import com.dequesystems.accessibility101.acronym.AcronymAnnouncementFixedFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescAboutFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescBrokenFragment;
import com.dequesystems.accessibility101.contentdescriptions.ContDescFixedFragment;
import com.dequesystems.accessibility101.edittexts.EditTextAboutFragment;
import com.dequesystems.accessibility101.edittexts.EditTextBrokenFragment;
import com.dequesystems.accessibility101.edittexts.EditTextFixedFragment;
import com.dequesystems.accessibility101.important.FragmentImportantAbout;
import com.dequesystems.accessibility101.important.FragmentImportantBroken;
import com.dequesystems.accessibility101.important.FragmentImportantFixed;
import com.dequesystems.accessibility101.introduction.AppIntroductionFragment;
import com.dequesystems.accessibility101.labels.LabelsAboutFragment;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;
import com.dequesystems.accessibility101.labels.LabelsFixedFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationAboutFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationBrokenFragment;
import com.dequesystems.accessibility101.tabbednavigation.TabbedNavigationFixedFragment;
import com.dequesystems.accessibility101.talkback.TalkBackAboutFragment;
import com.dequesystems.accessibility101.talkback.TalkBackAdvancedFragment;
import com.dequesystems.accessibility101.talkback.TalkBackDemosFragment;
import com.dequesystems.accessibility101.verybroken.FragmentVeryBroken;

import java.util.ArrayList;

/**
 * Created by chrismcmeeking on 4/24/15.
 *
 * Class that manages the different "stories" for the app. Also hosts the content addition of the navigation drawer and global tab bar.
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

        tempStory = new Story(mActivity.getString(R.string.aac_talkBack_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new TalkBackAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_talkBack_tab_title_demo), R.drawable.aac_cont_desc_icon, new TalkBackDemosFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_talkBack_tab_title_advanced), R.drawable.aac_fixed_icon, new TalkBackAdvancedFragment());
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

        tempStory = new Story(mActivity.getString(R.string.aac_acronym_annoucement_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new AcronymAnnouncementAboutFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new AcronymAnnouncementBrokenFragment());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new AcronymAnnouncementFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_important_title), true);
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_about), R.drawable.aac_about_icon, new FragmentImportantAbout());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_broken), R.drawable.aac_broken_icon, new FragmentImportantBroken());
        tempStory.addTab(mActivity.getString(R.string.aac_tab_title_fixed), R.drawable.aac_fixed_icon, new FragmentImportantFixed());
        this.add(tempStory);

        tempStory = new Story("Very Broken Demo", false);
        tempStory.addTab("Very Broken", R.drawable.aac_about_icon, new FragmentVeryBroken());
        add(tempStory);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LinearLayout navDrawerCellLayout = (LinearLayout) mActivity.getLayoutInflater().inflate(R.layout.navigation_drawer_cell, null);

        TextView textView = (TextView) navDrawerCellLayout.findViewById(R.id.aac_navigation_drawer_cell_text_view);
        textView.setText(this.getItem(position).getTitle());

        ImageView imageView = (ImageView) navDrawerCellLayout.findViewById(R.id.aac_navigation_drawer_cell_image_view);

        String text = textView.getText().toString();

        if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_intro_title))){
            imageView.setImageResource(R.drawable.aac_intro_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_talkBack_title))){
            imageView.setImageResource(R.drawable.aac_non_sighted_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title))){
            imageView.setVisibility(View.GONE);
            textView.setTextAppearance(getContext(), R.style.AACTextAppearance_navigation_drawer_heading);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_labels_title))){
            imageView.setImageResource(R.drawable.aac_labels_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_cont_desc_title))){
            imageView.setImageResource(R.drawable.aac_cont_desc_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_edit_text_title))){
            imageView.setImageResource(R.drawable.aac_edit_text_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_tab_nav_title))){
            imageView.setImageResource(R.drawable.aac_labels_icon);
        } else if (text.equalsIgnoreCase(mActivity.getString(R.string.aac_acronym_annoucement_title))){
            imageView.setImageResource(R.drawable.aac_broken_icon);
        } else {
            imageView.setImageResource(R.drawable.aac_about_icon);
        }

        final int DEMO_SPLIT_POSITION = 3;
        final int tabNumber = position < DEMO_SPLIT_POSITION ? position + 1 : position;
        if (!text.equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title))){
            navDrawerCellLayout.setContentDescription(text + ", tab " + tabNumber + " of " + (getCount() - 1));
        }else{
            navDrawerCellLayout.setContentDescription(text);
        }

        return navDrawerCellLayout;
    }

    @Override
    public boolean isEnabled(int position){
        return !getItem(position).getTitle().equalsIgnoreCase(mActivity.getString(R.string.aac_separator_heading_title));
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

                TabLayout view = (TabLayout) mActivity.getLayoutInflater().inflate(R.layout.tab_layout, null);
                view.setTabHost(tabHost);

                TextView textView = (TextView) view.findViewById(R.id.aac_tab_title);
                textView.setText(tab.getTitle());

                ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_image);
                imageView.setImageResource(tab.getImageResource());

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

                if (tabTitle.equalsIgnoreCase(tab.mTitle)) {
                    return tab;
                }
            }

            return null;
        }

        Tab getTabByID(String tabId) {

            for (int i = 0; i < mTabs.size(); i++) {
                Tab tab =  mTabs.get(i);

                if (tabId.equalsIgnoreCase(tab.getTabID())) {
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
