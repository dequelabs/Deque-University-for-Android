package com.dequesystems.accessibility101.labels;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;
import com.deque.worldspace.Rule.RuleSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by chris.mcmeeking@deque.com on 3/18/16.
 *
 * Instrumentation tests for the Labels broken fragment.
 */
public class LabelsBrokenFragmentTest {

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

        A11yAssert.setNodeInfoPrinter(new A11yAssert.NodeInfoPrinter() {
            @Override
            public String getString(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                return accessibilityNodeInfoCompat.toString();
            }
        });

        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .ruleSet(RuleSet.WCAG2_0)
                .isAccessible();
    }
}