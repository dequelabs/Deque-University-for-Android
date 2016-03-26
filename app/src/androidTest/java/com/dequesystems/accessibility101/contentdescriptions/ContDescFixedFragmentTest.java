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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by chrismcmeeking on 3/18/16.
 */
public class ContDescFixedFragmentTest {
    static {
        CLog.initialize("DequeA11yTest", BuildConfig.DEBUG);
    }

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