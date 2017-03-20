package com.dequesystems.accessibility101.contentdescriptions;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by chrismcmeeking on 3/18/16.
 */
public class ContDescFixedFragmentTest {


    @Rule
    public ActivityTestRule<MainActivity> mFragmentActivityRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setupFragment() {

        mActivity = mFragmentActivityRule.getActivity();

        TestUtils.replaceAllContentWithFragment(mActivity, new ContDescFixedFragment());
    }

    @Test
    public void testIsAccessible() {
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation()).isAccessible();
    }

}