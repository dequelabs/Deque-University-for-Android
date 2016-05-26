package com.dequesystems.accessibility101;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.support.design.widget.TabLayout;

import com.dequesystems.a11yframework.TabLayoutWrapper;

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
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_intro_tab_1)).setIcon(R.drawable.aac_about_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_talkBack_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_talkBack_tab_title_demo)).setIcon(R.drawable.aac_cont_desc_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_talkBack_tab_title_advanced)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_separator_heading_title), false, tempTabLayout);
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_labels_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_cont_desc_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_edit_text_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_tab_nav_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_acronym_annoucement_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        tempStory = new Story(mActivity.getString(R.string.aac_important_title), true, tempTabLayout);
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_about)).setIcon(R.drawable.aac_about_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_broken)).setIcon(R.drawable.aac_broken_icon));
        tempStory.addTab(tempTabLayout.newTab().setText(mActivity.getString(R.string.aac_tab_title_fixed)).setIcon(R.drawable.aac_fixed_icon));
        this.add(tempStory);

        if (BuildConfig.DEBUG) {
            tempStory = new Story("Very Broken Demo", false, tempTabLayout);
            tempStory.addTab(tempTabLayout.newTab().setText("Very Broken").setIcon(R.drawable.aac_about_icon));
            add(tempStory);
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

        private Story (String title, boolean tabBarVisible, TabLayout tabLayout) {
            mTitle = title;
            mTabBarVisible = tabBarVisible;
            mTabs = new ArrayList<>();
            mTabLayoutWrapper = new TabLayoutWrapper(tabLayout);
        }

        private void addTab(TabLayout.Tab tab) {
            String tabID =  Story.this.getTitle().toUpperCase() + "_" + mTitle.toUpperCase() + "_TAB";
            tab.setTag(tabID);

            mTabs.add(tab);
        }

        private void makeActiveStory() {
            mTabLayoutWrapper.clearTabs();


            final ColorFilter overlayColorDimmed = new PorterDuffColorFilter(mActivity.getResources().getColor(R.color.aac_tab_bar_dimmed), PorterDuff.Mode.SRC_IN);
            final ColorFilter overlayColorSelected = new PorterDuffColorFilter(mActivity.getResources().getColor(R.color.aac_tab_bar_selected), PorterDuff.Mode.SRC_IN);

            for (int i = 0; i < mTabs.size(); i++) {
                TabLayout.Tab tab = mTabs.get(i);

                if(i == 0) {tab.getIcon().setColorFilter(overlayColorSelected);}
                else {tab.getIcon().setColorFilter(overlayColorDimmed);}

                mTabLayoutWrapper.getTabLayout().addTab(tab);
            }

            mTabLayoutWrapper.setContentDescriptions();

            mTabLayoutWrapper.getTabLayout().setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mTabLayoutWrapper.setContentDescriptions();
                    tab.getIcon().setColorFilter(overlayColorSelected);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    mTabLayoutWrapper.setContentDescriptions();
                    tab.getIcon().setColorFilter(overlayColorDimmed);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            if (mTabBarVisible) {
                mTabLayoutWrapper.getTabLayout().setVisibility(View.VISIBLE);
            } else {
                mTabLayoutWrapper.getTabLayout().setVisibility(View.GONE);
            }

            mTabLayoutWrapper.getTabLayout().setBackgroundColor(mActivity.getResources().getColor(R.color.aac_tab_bar_background));
            mTabLayoutWrapper.getTabLayout().setTabTextColors(mActivity.getResources().getColor(R.color.aac_tab_bar_dimmed), mActivity.getResources().getColor(R.color.aac_tab_bar_selected));
            mTabLayoutWrapper.getTabLayout().setSelectedTabIndicatorColor(mActivity.getResources().getColor(R.color.aac_tab_bar_selected));

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
