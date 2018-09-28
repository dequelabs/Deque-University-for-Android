package com.deque.accessibilityanalyzer.application;

import android.content.Context;
import android.view.View;

/**
 * Created by chrismcmeeking on 7/19/17.
 */

public abstract class RuleDemo {

    String description;

    RuleDemo(String description) {
        this.description = description;
    }

    public abstract View onCreateView(Context context);

}
