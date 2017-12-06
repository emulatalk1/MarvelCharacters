package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import com.vnspectre.marvelcharacters.ui.base.MvpPresenter;

/**
 * Created by Spectre on 12/5/17.
 */

public interface CharactersMvpPresenter<V extends CharactersMvpView>  extends MvpPresenter<V> {

    void onViewPrepared();

    void onListEndReached(Integer offset, Integer limit);

}
