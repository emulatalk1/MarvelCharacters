package com.vnspectre.marvelcharacters.fragment.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.activity.MainActivity;

public class HomeFirstFragment extends Fragment implements OnClickListener{

    private Button btTopHeroes;

    public HomeFirstFragment() {
    }

    public static HomeFirstFragment newInstance() {
        HomeFirstFragment fragment = new HomeFirstFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFirst = inflater.inflate(R.layout.fragment_home_first, container, false);

        btTopHeroes = homeFirst.findViewById(R.id.bt_topHeroes);

        btTopHeroes.setOnClickListener(this);

        return homeFirst;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_topHeroes:
                ((MainActivity) getActivity()).getmNavController().pushFragment(HomeSecondFragment.newInstance());
                break;
        }
    }

}
