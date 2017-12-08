package com.vnspectre.marvelcharacters.ui.home.secondhome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vnspectre.marvelcharacters.ui.home.secondhome.characters.CharactersFragment;
import com.vnspectre.marvelcharacters.ui.home.secondhome.comics.HomeSecondContainer2Fragment;
import com.vnspectre.marvelcharacters.ui.home.secondhome.events.HomeSecondContainer3Fragment;

/**
 * Created by Spectre on 12/8/17.
 */

public class HomeSecondPagerAdapter extends FragmentStatePagerAdapter {

    public static final int CHARACTERS_TAB_CODE = 0;
    public static final int COMICS_TAB_CODE = 1;
    public static final int EVENTS_TAB_CODE = 2;

    public static final String CHARACTERS_TAB_STRING = "Chars";
    public static final String COMICS_TAB_STRING = "Comics";
    public static final String EVENTS_TAB_STRING = "Events";

    private int mTabCount;

    public HomeSecondPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
//            case 0:
//                return null;

            case CHARACTERS_TAB_CODE:
                return CharactersFragment.newInstance();

            case COMICS_TAB_CODE:
                return HomeSecondContainer2Fragment.newInstance();

            case EVENTS_TAB_CODE:
                return HomeSecondContainer3Fragment.newInstance();

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
