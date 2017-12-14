package com.vnspectre.marvelcharacters.ui.detail.characters.biography;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vnspectre.marvelcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BiographyFragment extends Fragment {

    private View mBiographyFragment;

    public BiographyFragment() {
        // Required empty public constructor
    }

    public static BiographyFragment newInstance() {
        BiographyFragment fragment = new BiographyFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         mBiographyFragment = inflater.inflate(R.layout.fragment_biography, container, false);

         return mBiographyFragment;
    }

}
