package com.vnspectre.marvelcharacters.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vnspectre.marvelcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSecondContainer1Fragment extends Fragment {


    public HomeSecondContainer1Fragment() {
        // Required empty public constructor
    }

    public static HomeSecondContainer1Fragment newInstance() {
        HomeSecondContainer1Fragment fragment = new HomeSecondContainer1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_second_container1, container, false);
    }

}