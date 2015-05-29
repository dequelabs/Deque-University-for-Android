package com.dequesystems.accessibility101;

import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

/**
 * Created by melindakothbauer on 5/29/15.
 */
public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen>{

    private SplashScreen mSpalshScreen;
    private ImageView mImageView;

    public SplashScreenTest(){
        super(SplashScreen.class);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();

        mSpalshScreen = getActivity();
        mImageView = (ImageView) mSpalshScreen.findViewById(R.id.splashScreen);
    }

    public void testPreconditions() {
        assertNotNull("mSplashScreeen is null", mSpalshScreen);
        assertNotNull("mImageView is null", mImageView);
    }

    public void testSplashScreenImageView_background(){
        final Drawable expected = mSpalshScreen.getResources().getDrawable(R.drawable.splash_screen);
        final Drawable actual = mImageView.getBackground();
        assertEquals(expected, actual);
    }

}
