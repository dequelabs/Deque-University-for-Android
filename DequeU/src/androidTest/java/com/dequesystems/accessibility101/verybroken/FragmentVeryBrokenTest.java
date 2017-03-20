package com.dequesystems.accessibility101.verybroken;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TabWidget;

import com.deque.worldspace.A11yNodeInfo;
import com.deque.worldspace.RuleControlLabels;
import com.deque.worldspace.RuleDroidTouchTargetSize;
import com.deque.worldspace.RuleEditTextControls;
import com.deque.worldspace.RuleImageViewControls;
import com.deque.worldspace.RuleTabWidgetControls;
import com.dequesystems.accessibility101.MainActivity;
import com.dequesystems.accessibility101.TestUtils;
import com.deque.worldspace.A11yAssert;
import com.deque.worldspace.Rule.RuleSet;


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

                //Use the WCAG 2.0
                .ruleSet(RuleSet.WCAG2_0)

                //Ignore all issues associated with the ControlLabel rule.
                .ignore(RuleControlLabels.class)

                //Ignore ONE issue associated with the EditTextControl rule.
                .ignore(RuleEditTextControls.class, new A11yNodeInfo.Matcher())

                //Ignore one issue associated with the TabWidget rule, on a node that is a TabWidget.
                .ignore(RuleTabWidgetControls.class, new A11yNodeInfo.Matcher().setClass(TabWidget.class))

                //Ignore one ImveView issue, on a node that has a null content description.
                .ignore(RuleImageViewControls.class, new A11yNodeInfo.Matcher().setContentDescription(null))

                .verboseOutput()

                .isAccessible();
    }
}