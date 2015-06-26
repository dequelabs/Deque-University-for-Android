package com.dequesystems.accessibility101;

import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by melinda.kothbauer@deque.com on 6/1/15.
 * Tests Splash Screen
 */
public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

    private static String LOG_TAG = "FUCKOFF";


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
        ImageView mImageView;

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

        assertTrue(compareDrawable((BitmapDrawable) expected, (BitmapDrawable) actual));
    }

    public void logDrawable(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        double ratio = (double)width / (double)height;
        Log.d(LOG_TAG, "W: " + Integer.toString(width) + " H:" + Integer.toString(height) + " R:" + Double.toString(ratio) + " Class:" + drawable.getClass().getCanonicalName());
    }

    public boolean compareDrawable(BitmapDrawable drawable1, BitmapDrawable drawable2) {
        return drawable1.getBitmap().sameAs(drawable2.getBitmap());
    }
}
