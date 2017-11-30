package com.vnspectre.marvelcharacters.ui.base;

/**
 * Created by Spectre on 11/30/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
