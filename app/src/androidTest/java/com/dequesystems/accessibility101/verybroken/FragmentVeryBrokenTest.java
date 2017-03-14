package com.dequesystems.accessibility101.verybroken;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.deque.worldspace.RuleDroidTouchTargetSize;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by chris.mcmeeking@deque.com on 3/24/16.
 *
 * Tests for the very broken fragment.  This is our "demo" test module.
 * The version committed to the repository will fail.  When we set up
 * CI we'll want to configure a test target that omits this test case.
 */
public class FragmentVeryBrokenTest {
    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new FragmentVeryBroken());
    }

    @Test
    public void testIsAccessible() {

        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation())
                .exceptRule(RuleDroidTouchTargetSize.class)
                .isAccessible();
    }
}