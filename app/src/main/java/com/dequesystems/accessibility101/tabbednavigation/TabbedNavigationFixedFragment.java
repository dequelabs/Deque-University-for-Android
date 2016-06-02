package com.dequesystems.accessibility101.tabbednavigation;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.support.design.widget.TabLayout;

import com.dequesystems.a11yframework.TabLayoutWrapper;
import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabbedNavigationFixedFragment extends Fragment {

    private TabLayout mTabLayout;
    private TabLayoutWrapper mTabLayoutWrapper;

    public TabbedNavigationFixedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tabbed_navigation_fixed, container, false);

        //Tab layout
        mTabLayout = (TabLayout) view.findViewById(R.id.tabNavFixedTabLayout);
        mTabLayoutWrapper = new TabLayoutWrapper(mTabLayout);

        mTabLayoutWrapper.getTabLayout().setBackgroundColor(ContextCompat.getColor(this.getActivity(), R.color.aac_demo_tab_bar_background));
        mTabLayoutWrapper.getTabLayout().setSelectedTabIndicatorColor(ContextCompat.getColor(this.getActivity(), R.color.aac_demo_tab_bar_selected));
        mTabLayoutWrapper.getTabLayout().setTabTextColors(ContextCompat.getColor(getActivity(), R.color.aac_demo_tab_bar_dimmed), ContextCompat.getColor(getActivity(), R.color.aac_demo_tab_bar_selected));

        mTabLayoutWrapper.getTabLayout().addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_cat_tab_title));
        mTabLayoutWrapper.getTabLayout().addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_dog_tab_title));
        mTabLayoutWrapper.getTabLayout().addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_fish_tab_title));

        mTabLayoutWrapper.setContentDescriptions();

        ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_nav_fixed_image_view);
        imageView.setImageDrawable(ContextCompat.getDrawable(this.getActivity(), R.drawable.cat));
        imageView.setContentDescription(getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc));

        mTabLayoutWrapper.getTabLayout().setOnTabSelectedListener(new android.support.design.widget.TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(android.support.design.widget.TabLayout.Tab tab) {
                mTabLayoutWrapper.setContentDescriptions();

                ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_nav_fixed_image_view);
                Drawable newImage;
                String contDesc;

                if (tab.getPosition() == 0) {
                    newImage = ContextCompat.getDrawable(getActivity(), R.drawable.cat);
                    contDesc = getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc);
                } else if (tab.getPosition() == 1) {
                    newImage = ContextCompat.getDrawable(getActivity(), R.drawable.dog);
                    contDesc = getResources().getString(R.string.aac_cont_desc_fixed_dog_cont_desc);
                } else {
                    newImage = ContextCompat.getDrawable(getActivity(), R.drawable.fish);
                    contDesc = getResources().getString(R.string.aac_cont_desc_fixed_fish_cont_desc);
                }

                imageView.setImageDrawable(newImage);
                imageView.setContentDescription(contDesc);
            }

            @Override
            public void onTabUnselected(android.support.design.widget.TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(android.support.design.widget.TabLayout.Tab tab) {
            }

        });

        return view;
    }
}
