package com.dequesystems.accessibility101.contentdescriptions;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.chriscm.clog.CLog;
import com.dequesystems.accessibility101.BuildConfig;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.R;
import com.dequesystems.accessibility101.TestUtils;
import com.dequesystems.accessibility101.labels.LabelsAboutFragment;
import com.dequesystems.axeandroid.A11yAssert;
import com.dequesystems.axeandroid.DroidRuleDuplicateClickableBounds;
import com.dequesystems.axeandroid.DroidRuleRedundantContDesc;
import com.dequesystems.axeandroid.RuleImageContDesc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by chris.mcmeeking@deque.com on 3/18/16.
 *
 * Instrumentation tests for the Broken Content Descriptions fragment
 */
public class ContDescBrokenFragmentTest {
    static {
        CLog.initialize("DequeA11yTest", BuildConfig.DEBUG);
    }

    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new ContDescBrokenFragment());
    }

    @Test
    public void testIsAccessible() {
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .acceptWarnings()
                .expectedFailure(RuleImageContDesc.class, null)
                .expectedFailure(RuleImageContDesc.class, " ")
                .isAccessible();
    }
}