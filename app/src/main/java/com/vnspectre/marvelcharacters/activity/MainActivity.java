package com.vnspectre.marvelcharacters.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemReselectedListener;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.fragment.browser.BrowserFragment;
import com.vnspectre.marvelcharacters.fragment.discover.DiscoverFragment;
import com.vnspectre.marvelcharacters.fragment.home.HomeFirstFragment;
import com.vnspectre.marvelcharacters.fragment.home.HomeSecondContainer3Fragment;
import com.vnspectre.marvelcharacters.fragment.home.HomeSecondFragment;
import com.vnspectre.marvelcharacters.fragment.mylibrary.MyLibraryFragment;
import com.vnspectre.marvelcharacters.utils.BottomNavigationViewHelper;
import com.vnspectre.marvelcharacters.utils.FragNavController;

public class MainActivity extends AppCompatActivity implements FragNavController.TransactionListener, FragNavController.RootFragmentListener {

    private final int INDEX_HOME = FragNavController.TAB1;
    private final int INDEX_DISCOVER = FragNavController.TAB2;
    private final int INDEX_BROWSER = FragNavController.TAB3;
    private final int INDEX_MY_LIBRARY = FragNavController.TAB4;
    private FragNavController mNavController;

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setSelectedItemId(INDEX_HOME);
        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.frame_layout_fragment)
                .transactionListener(this)
                .rootFragmentListener(this, 4)
                .build();

        bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_bottom_home:
                        mNavController.switchTab(INDEX_HOME);
                        break;
                    case R.id.action_bottom_discover:
                        mNavController.switchTab(INDEX_DISCOVER);
                        break;
                    case R.id.action_bottom_browser:
                        mNavController.switchTab(INDEX_BROWSER);
                        break;
                    case R.id.action_bottom_my_library:
                        mNavController.switchTab(INDEX_MY_LIBRARY);
                        break;
                }
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(new OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                mNavController.clearStack();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onTabTransaction(@Nullable Fragment fragment, int index) {
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {
            case INDEX_HOME:
                return HomeFirstFragment.newInstance();

            case INDEX_DISCOVER:
                return DiscoverFragment.newInstance();

            case INDEX_BROWSER:
                return BrowserFragment.newInstance();

            case INDEX_MY_LIBRARY:
                return MyLibraryFragment.newInstance();
        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    public FragNavController getmNavController() {
        return mNavController;
    }

    @Override
    public void onBackPressed() {
        if (!mNavController.isRootFragment()) {
            mNavController.popFragment();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mNavController.popFragment();
                break;
        }
        return true;
    }

}


