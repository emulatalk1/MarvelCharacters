package com.vnspectre.marvelcharacters.ui.detail.characters.comics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vnspectre.marvelcharacters.R;

public class ComicsFragment extends Fragment {

    public ComicsFragment() {
        // Required empty public constructor
    }

    public static ComicsFragment newInstance() {
        ComicsFragment fragment = new ComicsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false);
    }

}
