package com.dequesystems.accessibility101;

import android.app.Activity;


import com.chriscm.clog.CLog;
import com.dequesystems.axeandroid.A11yAssert;
import com.dequesystems.axeandroid.RuleAcronymAnnouncement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;


import static org.junit.Assert.*;

/**
 * Created by chrismcmeeking on 3/15/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    static {
        CLog.initialize(MainActivityTest.class.getSimpleName(), true);
    }

    Activity mActivity;

    @Before
    public void setUp() {

        mActivity = Robolectric.buildActivity(TestActivity.class).create().visible().get();

        ShadowLog.stream = System.out;
    }

    @Test
    public void testBrokenFragment() {

        mActivity.setContentView(R.layout.fragment_acronym_announcement_broken);

        A11yAssert.thatRoboActivity(mActivity).allRules().exceptRule(RuleAcronymAnnouncement.class).passes();

        A11yAssert.thatRoboActivity(mActivity).rule(RuleAcronymAnnouncement.class).fails();

    }

    @Test
    public void testSwitchFail() {

        mActivity.setContentView(R.layout.fragment_acronym_announcement_fixed);

        A11yAssert.thatRoboActivity(mActivity).passes();

    }
}