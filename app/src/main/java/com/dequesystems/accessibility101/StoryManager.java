package com.dequesystems.accessibility101;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dequesystems.a11yframework.TabLayoutWrapper;
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

    MainActivity mActivity;

    private Story mActiveStory = null;

    public static final int STORY_INDEX_ACRONYMS = 7;

    StoryManager(MainActivity activity) {
        super(activity, 0, /*objects*/new ArrayList<Story>());

        mActivity = activity;


        TabLayout tempTabLayout = (TabLayout) mActivity.findViewById(R.id.globalTabLayout);

        Story tempStory = new Story(mActivity.getString(R.string.aac_intro_title), false, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_intro_tab_1)).setIcon(R.drawable.aac_about_icon), new AppIntroductionFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_talkBack_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new TalkBackAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_talkBack_tab_title_demo)).setIcon(R.drawable.aac_cont_desc_icon), new TalkBackDemosFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_talkBack_tab_title_advanced)).setIcon(R.drawable.aac_fixed_icon), new TalkBackAdvancedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_separator_heading_title), false, tempTabLayout);
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_labels_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new LabelsAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new LabelsBrokenFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new LabelsFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_cont_desc_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new ContDescAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new ContDescBrokenFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new ContDescFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_edit_text_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new EditTextAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new EditTextBrokenFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new EditTextFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_tab_nav_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new TabbedNavigationAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new TabbedNavigationBrokenFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new TabbedNavigationFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_acronym_annoucement_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new AcronymAnnouncementAboutFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new AcronymAnnouncementBrokenFragment());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new AcronymAnnouncementFixedFragment());
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_important_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon), new FragmentImportantAbout());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon), new FragmentImportantBroken());
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon), new FragmentImportantFixed());
        this.add(tempStory);

        if (BuildConfig.DEBUG) {
            tempStory = new Story("Very Broken Demo", false, tempTabLayout);
            tempStory.addTab(tempTabLayout.newTab().setText("Very Broken").setIcon(R.drawable.aac_about_icon), new FragmentVeryBroken());
            this.add(tempStory);
        }
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

    public void setActiveStory(int index) {
        this.getItem(index).makeActiveStory();
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

        ArrayList<android.support.design.widget.TabLayout.Tab> mTabs;

        TabLayoutWrapper mTabLayoutWrapper;

        ArrayList<Fragment> mFragments;

        private Story (String title, boolean tabBarVisible, TabLayout tabLayout) {
            mTitle = title;
            mTabBarVisible = tabBarVisible;
            mTabs = new ArrayList<>();
            mFragments = new ArrayList<>();
            mTabLayoutWrapper = new TabLayoutWrapper(tabLayout);
        }

        private void addTab(TabLayout.Tab tab, Fragment fragment) {
            String tabID =  Story.this.getTitle().toUpperCase() + "_" + mTitle.toUpperCase() + "_TAB";
            tab.setTag(tabID);

            mTabs.add(tab);

            //mActivity.getSupportFragmentManager().beginTransaction().add().commit();
            mFragments.add(fragment);
        }

        private void makeActiveStory() {
            //clear the general tablayout and add tabs for the active story
            mTabLayoutWrapper.getTabLayout().removeAllTabs();

            //set colors used for tabs text and icons
            final ColorFilter overlayColorDimmed = new PorterDuffColorFilter(mActivity.getResources().getColor(R.color.aac_tab_bar_dimmed), PorterDuff.Mode.SRC_IN);
            final ColorFilter overlayColorSelected = new PorterDuffColorFilter(mActivity.getResources().getColor(R.color.aac_tab_bar_selected), PorterDuff.Mode.SRC_IN);

            //add tabs to tablayout and set initial colors
            for(int i = 0; i < mTabs.size(); i++) {
                TabLayout.Tab tab = mTabs.get(i);
                if(i == 0) {
                    tab.getIcon().setColorFilter(overlayColorSelected);
                    tab.select();
                }
                else {
                    tab.getIcon().setColorFilter(overlayColorDimmed);
                }
                mTabLayoutWrapper.getTabLayout().addTab(tab);
            }
            //use acccessible wrapper to update content descriptions
            mTabLayoutWrapper.setContentDescriptions();

            //set up view pager with specific adapter that returns fragments for this story
            final ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.globalViewPager);
            final FragmentPagerAdapter fragmentPagerAdapter = new TabFragmentPagerAdapter(mActivity.getSupportFragmentManager(), mFragments.size(), mFragments);
            viewPager.setAdapter(fragmentPagerAdapter);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayoutWrapper.getTabLayout()));

            mTabLayoutWrapper.getTabLayout().setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mTabLayoutWrapper.setContentDescriptions();
                    tab.getIcon().setColorFilter(overlayColorSelected);

                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    tab.getIcon().setColorFilter(overlayColorDimmed);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            //this allows stories to not include tab bar
            if (mTabBarVisible) {
                mTabLayoutWrapper.getTabLayout().setVisibility(View.VISIBLE);
            } else {
                mTabLayoutWrapper.getTabLayout().setVisibility(View.GONE);
            }

            //sytle the tablayout
            mTabLayoutWrapper.getTabLayout().setBackgroundColor(mActivity.getResources().getColor(R.color.aac_tab_bar_background));
            mTabLayoutWrapper.getTabLayout().setTabTextColors(mActivity.getResources().getColor(R.color.aac_tab_bar_dimmed), mActivity.getResources().getColor(R.color.aac_tab_bar_selected));
            mTabLayoutWrapper.getTabLayout().setSelectedTabIndicatorColor(mActivity.getResources().getColor(R.color.aac_tab_bar_selected));

            //set the active story
            StoryManager.this.mActiveStory = this;
        }

        String getTitle() { return mTitle;}

        android.support.design.widget.TabLayout.Tab getTabByTitle(String tabTitle) {

            for (int i = 0; i < mTabs.size(); i++ ) {
                android.support.design.widget.TabLayout.Tab tab = mTabs.get(i);

                if (tabTitle.equalsIgnoreCase(tab.getText().toString())) {
                    return tab;
                }
            }

            return null;
        }

        android.support.design.widget.TabLayout.Tab getTabByTag(String tabId) {

            for (int i = 0; i < mTabs.size(); i++) {
                android.support.design.widget.TabLayout.Tab tab =  mTabs.get(i);

                if (tabId.equalsIgnoreCase(tab.getTag().toString())) {
                    return tab;
                }
            }

            return null;
        }
    }
}
