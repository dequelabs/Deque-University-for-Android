package com.dequesystems.accessibility101;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.test.InstrumentationRegistry;

import com.dequesystems.accessibility101.acronym.AcronymAnnouncementBrokenFragment;

/**
 * Created by chrismcmeeking on 3/17/16.
 */
public class TestUtils {
    private TestUtils() {}

    public static void replaceAllContentWithFragment(Activity activity, Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
    }
}

