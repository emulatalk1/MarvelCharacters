package com.vnspectre.marvelcharacters.ui.home.secondhome.comics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vnspectre.marvelcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSecondContainer2Fragment extends Fragment {


    public HomeSecondContainer2Fragment() {
        // Required empty public constructor
    }

    public static HomeSecondContainer2Fragment newInstance() {
        HomeSecondContainer2Fragment fragment = new HomeSecondContainer2Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_second_container2, container, false);
    }

}
