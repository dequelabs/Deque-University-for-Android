package com.dequesystems.accessibility101;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/*
 *Created by melinda.kothbauer@deque.com
 *
 * Loads the splash screen & waits before launching MainActivity
 */

public class SplashScreen extends Activity {

    private static boolean splashLoaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!splashLoaded) {

            setContentView(R.layout.activity_splash_screen);
            splashLoaded = true;

            int secondsDelayed = 2;

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 500);
        }
        else {
            Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }
    }
}
