package com.vnspectre.marvelcharacters.ui.home.firsthome;

import com.vnspectre.marvelcharacters.ui.base.MvpPresenter;

/**
 * Created by Spectre on 11/30/17.
 */

public interface HomeFirstMvpPresenter<V extends HomeFirstMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}
