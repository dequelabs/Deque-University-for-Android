package com.dequesystems.a11yframework;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by chrismcmeeking on 10/14/15.
 */
public class LoggingAccessibilityDelegate extends View.AccessibilityDelegate {

    public LoggingAccessibilityDelegate(String logTag) {
        LOG_TAG = logTag;
    }

    private static final int LOG_LEVEL = Log.DEBUG;
    private String LOG_TAG = LoggingAccessibilityDelegate.class.getSimpleName();

    @Override
    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        Log.println(LOG_LEVEL, LOG_TAG, "dispatchPopulateAccessibilityEvent " + event.toString());
        return super.dispatchPopulateAccessibilityEvent(host, event);
    }

    @Override
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        Log.println(LOG_LEVEL, LOG_TAG, "onInitializeAccessibilityEvent " + event.toString());

        super.onInitializeAccessibilityEvent(host, event);
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo nodeInfo) {
        Log.println(LOG_LEVEL, LOG_TAG, "onInitializeAccessibilityNodeInfo " + nodeInfo.toString());
        super.onInitializeAccessibilityNodeInfo(host, nodeInfo);
    }

    @Override
    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        Log.println(LOG_LEVEL, LOG_TAG, "onPopulateAccessibilityEvent " + event.toString());
        super.onPopulateAccessibilityEvent(host, event);
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View child, AccessibilityEvent event) {

        Log.println(LOG_LEVEL, LOG_TAG, "onRequestSendAccessibilityEvent " + event.toString());

        return super.onRequestSendAccessibilityEvent(viewGroup, child, event);
    }

    @Override
    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        Log.println(LOG_LEVEL, LOG_TAG, "performAccessibilityAction");
        return super.performAccessibilityAction(host, action, args);
    }

    @Override
    public void sendAccessibilityEvent(View host, int eventType) {
        Log.println(LOG_LEVEL, LOG_TAG, "sendAccessibilityEvent");
        super.sendAccessibilityEvent(host, eventType);
    }
}
