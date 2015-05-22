package com.dequesystems.a11yframework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * Created by chrismcmeeking on 5/22/15.
 */
public class TabLayout extends LinearLayout {

    TabLayoutCallbacks mCallbacks;

    private static final String LOG_TAG = TabLayout.class.getSimpleName();

    private void initialize() {
        mCallbacks = (TabLayoutCallbacks)getContext();
    }

    public TabLayout(Context context) {
        super(context);

        initialize();
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize();
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public CharSequence getContentDescription() {

        final TabHost tabHost = mCallbacks.getTabHost();
        final TabWidget tabWidget = tabHost.getTabWidget();
        final View view = tabWidget.getChildTabViewAt(tabHost.getCurrentTab());
        final int tabCount = tabWidget.getTabCount();
        int tabNumber;

        for (tabNumber = 0; tabNumber < tabCount; tabNumber++) {
            if (this == tabWidget.getChildTabViewAt(tabNumber)) break;
        }

        CharSequence contentDescription = findContentDescription(this);

        if (contentDescription == null) {
            //TODO: Throw a proper exception.
            Log.wtf(LOG_TAG, "Content Description should not be null, we need to throw an exception here");
        }

        if (view == this) {
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

    public static interface TabLayoutCallbacks {
        TabHost getTabHost();
    }
}
