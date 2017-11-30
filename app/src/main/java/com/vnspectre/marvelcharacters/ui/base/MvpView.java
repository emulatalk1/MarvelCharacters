package com.vnspectre.marvelcharacters.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Spectre on 11/30/17.
 */

public interface MvpView {

    void onError(String message);

    void showMessage(String message);

    boolean isNetworkConnected();
}
