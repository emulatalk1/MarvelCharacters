package com.vnspectre.marvelcharacters.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.activity.MainActivity;
import com.vnspectre.marvelcharacters.utils.CommonUtils;
import com.vnspectre.marvelcharacters.utils.NetworkUtils;

/**
 * Created by Spectre on 11/30/17.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    private MainActivity mActivity;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mActivity = (MainActivity) getActivity();
        }
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mActivity.getApplication());
    }

    public MainActivity getMainActivity() {
        return mActivity;
    }

    protected abstract void setUp(View view);
}
