package com.dequesystems.accessibility101.tabbednavigation;


import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabbedNavigationAboutFragment extends Fragment {

    //private TabHost mTabHost;
    private TabLayout mTabLayout;


    TextView mTextView1;


    public TabbedNavigationAboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tabbed_navigation_about, container, false);


        //Link text view
        mTextView1 = (TextView) view.findViewById(R.id.aacTabNavTextView1);

        mTextView1.setMovementMethod(LinkMovementMethod.getInstance());

        int linkColor = ContextCompat.getColor(this.getActivity(), R.color.aac_text_link);

        mTextView1.setLinkTextColor(linkColor);

        //Tab layout
        mTabLayout = (TabLayout) view.findViewById(R.id.tabNavAboutTabLayout);

        mTabLayout.setBackgroundColor(ContextCompat.getColor(this.getActivity(), R.color.aac_demo_tab_bar_background));
        mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this.getActivity(), R.color.aac_demo_tab_bar_selected));

        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_cat_tab_title));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_dog_tab_title));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.aac_tab_nav_fish_tab_title));

        ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_nav_about_image_view);
        imageView.setImageDrawable(ContextCompat.getDrawable(this.getActivity(), R.drawable.cat));
        imageView.setContentDescription(getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc));

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabLayout.setTabTextColors(ContextCompat.getColor(getActivity(), R.color.aac_demo_tab_bar_dimmed), ContextCompat.getColor(getActivity(), R.color.aac_demo_tab_bar_selected));

                ImageView imageView = (ImageView) view.findViewById(R.id.aac_tab_nav_about_image_view);
                Drawable newImage;
                String contDesc;

                if (mTabLayout.getSelectedTabPosition() == 0) {
                    newImage = ContextCompat.getDrawable(getActivity(), R.drawable.cat);
                    contDesc = getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc);
                } else if (mTabLayout.getSelectedTabPosition() == 1) {
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
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });

        return view;
    }

}
