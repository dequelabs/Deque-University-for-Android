package com.dequesystems.accessibility101;

import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.dequesystems.accessibility101.StoryManager.Story;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    private StoryManager mStoryManager;

    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = getTitle();

        mTabHost = (TabHost)findViewById(R.id.tabHost);
        mTabHost.setup();

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int tab = mTabHost.getCurrentTab();

                for(int i = 0; i < mTabHost.getTabWidget().getTabCount(); i++){
                    ImageView imageView = (ImageView) mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(R.id.aac_tab_image);
                    TextView textView = (TextView) mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(R.id.aac_tab_title);

                    int color;

                    if(i == tab){
                        color = getResources().getColor(R.color.aac_tab_bar_selected);
                    } else {
                        color = getResources().getColor(R.color.aac_tab_bar_dimmed);
                    }

                    imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    textView.setTextColor(color);
                }
            }
        });

        mStoryManager = new StoryManager(this);

        //Set up Navigation Drawer
        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), this.mStoryManager);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Navigation Drawer Callbacks and support functions

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        onSectionAttached(position);
        //TODO: Change content based on navigation drawer selection
    }

    public void onSectionAttached(int number) {
        Log.v(LOG_TAG, "Attaching new section: " + number);
        mStoryManager.setActiveStory(number, mTabHost);
        mTitle = mStoryManager.getActiveStory().getTitle();
    }

    public String[] getSectionHeadings() {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < mStoryManager.getCount(); i++ ) {
            result.add(mStoryManager.getItem(i).getTitle());
        }

        return result.toArray(new String[result.size()]);
    }
}
