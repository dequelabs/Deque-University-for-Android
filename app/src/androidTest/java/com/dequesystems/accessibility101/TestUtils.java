package com.dequesystems.accessibility101;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.v4.app.FragmentActivity;

import com.dequesystems.accessibility101.acronym.AcronymAnnouncementBrokenFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by chrismcmeeking on 3/17/16.
 */
public class TestUtils {
    private TestUtils() {}

    public static void replaceAllContentWithFragment(FragmentActivity activity, Fragment fragment) {
        onView(withId(R.id.aac_main_content)).check(matches(isDisplayed()));

        android.support.v4.app.FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.aac_main_content, fragment);
        fragmentTransaction.commit();

        while (true) {

            if (InstrumentationRegistry.getInstrumentation().getUiAutomation().getRootInActiveWindow() != null) {
                break;
            }

            InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        }

    }
}

