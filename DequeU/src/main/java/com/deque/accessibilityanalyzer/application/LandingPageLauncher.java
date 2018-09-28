package com.deque.accessibilityanalyzer.application;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.deque.rulestubs.Rule;
import com.deque.worldspace.RuleActivity;

public class LandingPageLauncher extends LandingPageItem {

    private int image;
    private Class clazz;

    LandingPageLauncher(Context context, int title, int image, Class clazz) {
        super(context, title);
        this.image = image;
        this.clazz = clazz;
    }

    @Override
    public TextView.OnClickListener launch() {
        return (View v) -> {

            Intent activityIntent = null;
            if (clazz != Rule.class && clazz.getSuperclass() == Rule.class) {
                try {
                    activityIntent = RuleActivity.newInstance(context, clazz);
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            } else {
                activityIntent = new Intent(context, TalkBackAboutActivity.class);
            }
            context.startActivity(activityIntent);
        };
    }

    public int getImage() {
        return image;
    }
}
