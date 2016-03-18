package com.dequesystems.accessibility101.acronym;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.chriscm.clog.CLog;
import com.dequesystems.accessibility101.BuildConfig;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.dequesystems.axeandroid.A11yAssert;
import com.dequesystems.axeandroid.RuleAcronymAnnouncement;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chrismcmeeking on 3/18/16.
 */
public class AcronymAnnouncementBrokenFragmentTest {

    static {
        CLog.initialize(AcronymAnnouncementAboutFragmentTest.class.getSimpleName(), BuildConfig.DEBUG);
    }
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
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation()).rule(RuleAcronymAnnouncement.class).fails();
        A11yAssert.thatInstrumentation(InstrumentationRegistry.getInstrumentation()).allRules().exceptRule(RuleAcronymAnnouncement.class).passes();
    }
}