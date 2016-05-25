package com.dequesystems.a11yframework;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * Created by chris.mcmeeking@deque.com on 5/22/15.
 *
 * Framework class that makes tab bars accessible by adding the state, role, and value to tabs' content descriptions
 * Can be implemented by inflating a custom xml layout that uses this class
 */
public class TabLayout extends android.support.design.widget.TabLayout {

    private com.dequesystems.a11yframework.TabLayout mTabLayout;

    private static final String LOG_TAG = TabLayout.class.getSimpleName();


    public TabLayout(Context context) {
        super(context);
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


    @Override
    public CharSequence getContentDescription() {

        final android.support.design.widget.TabLayout.Tab tab = mTabLayout.getTabAt(mTabLayout.getSelectedTabPosition());
        final int tabCount = mTabLayout.getTabCount();
        int tabNumber;

        for (tabNumber = 0; tabNumber < tabCount; tabNumber++) {
            if (this.getTabAt(tabNumber) == mTabLayout.getTabAt(tabNumber)) break;
        }

        CharSequence contentDescription = findContentDescription(this);

        if (contentDescription == null) {
            //TODO: Throw a proper exception.
            Log.wtf(LOG_TAG, "Content Description should not be null, we need to throw an exception here");
        }

        if (tab == this.getTabAt(this.getSelectedTabPosition())) {
            contentDescription = contentDescription + ", selected";
        }

        contentDescription = contentDescription + ", tab " + (tabNumber + 1) + " of " + tabCount;

        return contentDescription;
    }

    private CharSequence findContentDescription(View view) {

        if (view == null) return null;

        CharSequence contentDescription = null;

        if (TextView.class.isInstance(view)) {
            TextView textView = (TextView)view;

            contentDescription = textView.getText();
        }

        if (contentDescription != null) return contentDescription;

        if (ViewGroup.class.isInstance(view)) {
            ViewGroup viewGroup = (ViewGroup)view;

            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                contentDescription = findContentDescription(viewGroup.getChildAt(i));

                if (contentDescription != null) return contentDescription;
            }
        }

        return null;
    }

    public void setTabLayout(com.dequesystems.a11yframework.TabLayout tabLayout) {
        mTabLayout = tabLayout;
    }

}
