package com.dequesystems.accessibility101.acronym;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.deque.worldspace.RuleDroidTouchTargetSize;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;
import com.deque.worldspace.RuleAcronymAnnouncement;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by chris.mcmeeking@deque.com on 3/18/16.
 *
 * Instrumentation tests for the broken Acronym Announcement fragment
 */
public class AcronymAnnouncementBrokenFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new AcronymAnnouncementBrokenFragment());
    }

    @Test
    public void testIsAccessible() {

        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .exceptRule(RuleDroidTouchTargetSize.class)
                .isAccessible();
    }
}