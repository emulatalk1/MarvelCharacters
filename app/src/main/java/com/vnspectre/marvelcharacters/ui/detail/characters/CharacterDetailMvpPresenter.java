package com.vnspectre.marvelcharacters.ui.detail.characters;

import com.vnspectre.marvelcharacters.ui.base.MvpPresenter;
import com.vnspectre.marvelcharacters.ui.base.MvpView;

/**
 * Created by Spectre on 12/12/17.
 */

public interface CharacterDetailMvpPresenter <V extends CharacterDetailMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
}
