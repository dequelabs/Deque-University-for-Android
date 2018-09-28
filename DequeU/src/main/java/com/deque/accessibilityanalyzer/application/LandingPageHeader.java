package com.deque.accessibilityanalyzer.application;

import android.content.Context;

public class LandingPageHeader extends LandingPageItem{

    private int body;

    public LandingPageHeader(Context context, int title, int body) {
        super(context, title);
        this.body = body;
    }

    public int getBody() {
        return body;
    }
}
