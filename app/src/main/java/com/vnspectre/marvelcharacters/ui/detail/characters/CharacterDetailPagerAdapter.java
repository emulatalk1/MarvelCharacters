package com.vnspectre.marvelcharacters.ui.detail.characters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.vnspectre.marvelcharacters.ui.detail.characters.biography.BiographyFragment;
import com.vnspectre.marvelcharacters.ui.detail.characters.comics.ComicsFragment;
import com.vnspectre.marvelcharacters.ui.detail.characters.events.EventsFragment;

/**
 * Created by Spectre on 12/12/17.
 */

public class CharacterDetailPagerAdapter extends FragmentStatePagerAdapter {

    public static final int BIO_TAB_CODE = 0;
    public static final int COMICS_TAB_CODE = 1;
    public static final int EVENTS_TAB_CODE = 2;

    public static final String BIO_TAB_STRING = "Biography";
    public static final String COMICS_TAB_STRING = "Comics";
    public static final String EVENTS_TAB_STRING = "Events";

    private int mTabCount;

    public CharacterDetailPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case BIO_TAB_CODE:
                Log.d("Hieu", "getItem: BIO");
                return BiographyFragment.newInstance();

            case COMICS_TAB_CODE:
                Log.d("Hieu", "getItem: COMICS");
                return ComicsFragment.newInstance();

            case EVENTS_TAB_CODE:
                Log.d("Hieu", "getItem: EVENTS");
                return EventsFragment.newInstance();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
