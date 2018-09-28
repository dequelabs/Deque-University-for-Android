package com.deque.accessibilityanalyzer.application;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.deque.accessibilityanalyzer.R;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private boolean mIsOverlayOn = false;
    private View mOverlayView;
    private RelativeLayout mMainView;
    private RecyclerView recyclerView;
    private LandingPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainView = findViewById(R.id.aac_main_content);

        mMainView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);

        observeOverlayIsOn();

        adapter = new LandingPageAdapter(this);
        recyclerView = findViewById(R.id.demo_recycler_view);
        recyclerView.setLayoutManager(getRulesLayoutManager());
        recyclerView.setAdapter(adapter);
    }

    private GridLayoutManager getRulesLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        glm.setSpanSizeLookup(getGridSpanSizeLookup());
        return glm;
    }

    private GridLayoutManager.SpanSizeLookup getGridSpanSizeLookup() {
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getSpanSize(position);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_example) {
            toggleOverlayIsOn(item);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isOverlayOn() {
        return mIsOverlayOn;
    }

    public void toggleOverlayIsOn(MenuItem item) {
        mIsOverlayOn = !mIsOverlayOn;

        if (mIsOverlayOn) {
            item.setIcon(getResources().getDrawable(R.drawable.aac_sighted_icon));
            item.setTitle(getResources().getString(R.string.aac_talkBack_switch_on));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.aac_non_sighted_icon));
            item.setTitle(getResources().getString(R.string.aac_talkBack_switch_off));
        }

        observeOverlayIsOn();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static View findAccessibilityFocus(View view) {
        if (view == null) return view;

        if (view.isAccessibilityFocused()) return view;

        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;

            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childView = viewGroup.getChildAt(i);

                View result = findAccessibilityFocus(childView);

                if (result != null) return result;
            }
        }

        return null;
    }

    public void observeOverlayIsOn() {

        if (mIsOverlayOn) {
            logDebug("Adding Overlay");

            if (mOverlayView == null) {
                mOverlayView = new ImageView(this);
                mOverlayView.setBackgroundColor(getResources().getColor(R.color.aac_deque_gray));
            }

            if (mOverlayView.getParent() != null) {
                mMainView.removeView(mOverlayView);
            }

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mMainView.getLayoutParams());

            layoutParams.setMargins(0,0,0,0);

            mMainView.addView(mOverlayView, layoutParams);

            Log.wtf(LOG_TAG, mMainView.toString());

        } else {
            mMainView.removeView(mOverlayView);
        }
    }

    private void logDebug(String message) {
            Log.d(LOG_TAG, message);
    }
}