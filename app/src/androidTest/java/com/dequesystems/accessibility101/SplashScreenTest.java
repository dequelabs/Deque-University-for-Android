package com.dequesystems.accessibility101;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by melindakothbauer on 6/1/15.
 */
public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

    private static String LOG_TAG = "FUCKOFF";

    private static ImageView mImageView;

    private static int mTestNumber = 0;

    public SplashScreenTest() {
        super(SplashScreen.class);
        Log.wtf(LOG_TAG, "I'm a constructor: " + Integer.toString(mTestNumber++));
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Log.wtf(LOG_TAG, "setUp: " + getActivity().toString());

    }

    public void testSplashScreen_backgroundImage() {

        Log.wtf(LOG_TAG, "testSplashScreen");

        Drawable expected;
        Drawable actual;

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mImageView = (ImageView) getActivity().findViewById(R.id.splashScreenP);
            actual = mImageView.getBackground();
            expected = getActivity().getResources().getDrawable(R.drawable.splash_screen_portrait);
        }else{
            mImageView = (ImageView) getActivity().findViewById(R.id.splashScreenL);
            actual = mImageView.getBackground();
            expected = getActivity().getResources().getDrawable(R.drawable.splash_screen_land);
        }

        assertEquals(expected.getConstantState().equals(actual.getConstantState()), true);

        assertNotNull("mImageView is null", mImageView);
    }

}
