package com.dequesystems.accessibility101.labels;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.chriscm.clog.CLog;
import com.dequesystems.accessibility101.BuildConfig;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.R;
import com.dequesystems.accessibility101.TestUtils;
import com.dequesystems.axeandroid.A11yAssert;
import com.dequesystems.axeandroid.RuleControlLabels;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by chris.mcmeeking@deque.com on 3/18/16.
 *
 * Instrumentation tests for the Labels broken fragment.
 */
public class LabelsBrokenFragmentTest {
    static {
        CLog.initialize("DequeA11yTest", BuildConfig.DEBUG);
    }

    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new LabelsBrokenFragment());
    }

    @Test
    public void testIsAccessible() {
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .expectedFailure(RuleControlLabels.class, null)
                .expectedFailure(RuleControlLabels.class, null)
                .expectedFailure(RuleControlLabels.class, null)
                .acceptWarnings()
                .isAccessible();
    }
}