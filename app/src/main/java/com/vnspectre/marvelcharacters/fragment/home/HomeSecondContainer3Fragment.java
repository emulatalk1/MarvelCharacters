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
public class HomeSecondContainer3Fragment extends Fragment {


    public HomeSecondContainer3Fragment() {
        // Required empty public constructor
    }

    public static HomeSecondContainer3Fragment newInstance() {
        HomeSecondContainer3Fragment fragment = new HomeSecondContainer3Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_second_container3, container, false);
    }

}
