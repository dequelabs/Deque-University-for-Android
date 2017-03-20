package com.dequesystems.accessibility101.contentdescriptions;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.deque.worldspace.RuleDroidTouchTargetSize;
import com.dequesystems.accessibility101.BuildConfig;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;
import com.deque.worldspace.RuleImageViewControls;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by chris.mcmeeking@deque.com on 3/18/16.
 *
 * Instrumentation tests for the Content Descriptions about fragment.
 */
public class ContDescAboutFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new ContDescAboutFragment());

    }

    @Test
    public void testIsAccessible() {
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .isAccessible();
    }
}