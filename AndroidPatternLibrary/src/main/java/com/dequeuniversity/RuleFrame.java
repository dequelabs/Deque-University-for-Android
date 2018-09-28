package com.dequeuniversity;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public abstract class RuleFrame {
    public abstract void setListeners(FrameLayout frameLayout);

    public int getLayoutId() {
        throw new UnsupportedOperationException("You need to implement the layout ID in your child of RuleFrame");
    }

    //Attribution to user Takhion, https://stackoverflow.com/a/16193267
    public void preventInitialFocus(final Activity activity) {
        final ViewGroup content = (ViewGroup) activity.findViewById(android.R.id.content);
        final View root = content.getChildAt(0);
        if (root == null) return;
        final View focusDummy = new View(activity);
        focusDummy.setFocusable(true);
        focusDummy.setFocusableInTouchMode(true);
        content.addView(focusDummy, 0, new LinearLayout.LayoutParams(0, 0));

        root.setOnFocusChangeListener((view, b) -> {
            view.setOnFocusChangeListener(null);
            content.removeView(focusDummy);
        });
    }
}
