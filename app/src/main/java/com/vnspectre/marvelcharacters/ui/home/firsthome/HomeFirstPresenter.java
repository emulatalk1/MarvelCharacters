package com.vnspectre.marvelcharacters.ui.home.firsthome;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;

/**
 * Created by Spectre on 11/30/17.
 */

public class HomeFirstPresenter<V extends HomeFirstMvpView> extends BasePresenter<V> implements HomeFirstMvpPresenter<V> {

    public HomeFirstPresenter(DataManager mDataManager, V mMvpView) {
        super(mDataManager, mMvpView);
    }

    @Override
    public void onViewPrepared() {

    }
}
