package com.vnspectre.marvelcharacters.fragment.home;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.activity.MainActivity;

public class HomeSecondFragment extends Fragment implements View.OnClickListener {

    private Button btBacktoFirstFragment;
    private Button btContainer1;
    private Button btContainer2;
    private Button btContainer3;

    public HomeSecondFragment() {
        // Required empty public constructor
    }

    public static HomeSecondFragment newInstance() {
        HomeSecondFragment fragment = new HomeSecondFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_second, container, false);

        btBacktoFirstFragment = view.findViewById(R.id.bt_backHome);
        btContainer1 = view.findViewById(R.id.bt_womenHeroes);
        btContainer2 = view.findViewById(R.id.bt_topVillains);
        btContainer3 = view.findViewById(R.id.bt_secondTopHeroes);

        btBacktoFirstFragment.setOnClickListener(this);
        btContainer1.setOnClickListener(this);
        btContainer2.setOnClickListener(this);
        btContainer3.setOnClickListener(this);
        btContainer3.callOnClick();

        return view;
    }

    @Override
    public void onClick(View view) {
        int item = view.getId();
        switch (item) {
            case R.id.bt_backHome:
                ((MainActivity) getActivity()).getmNavController().popFragment();
                Log.i("Back", "onClick: back");
                break;

            case R.id.bt_womenHeroes:
                replace(HomeSecondContainer1Fragment.newInstance());
                Log.i("women", "onClick: women");
                changeBackgroundTopNavigation(btContainer1);
                break;

            case R.id.bt_topVillains:
                replace(HomeSecondContainer2Fragment.newInstance());
                changeBackgroundTopNavigation(btContainer2);
                break;

            case R.id.bt_secondTopHeroes:
                replace(HomeSecondContainer3Fragment.newInstance());
                changeBackgroundTopNavigation(btContainer3);
                break;

//            case R.id.bt_topHeroes:
//                replace(HomeSecondContainer3Fragment.newInstance());
//                changeBackgroundTopNavigation(btContainer3);
//                break;
        }
    }

    public void replace(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_home_second_fragment_container, fragment).commit();
    }

    private void changeBackgroundTopNavigation(Button button) {
        int buttonId = button.getId();
        switch (buttonId) {
            case R.id.bt_womenHeroes:
                btContainer1.setBackgroundResource(R.drawable.background_button_clicked);
                btContainer2.setBackgroundResource(R.drawable.background_button_unclicked);
                btContainer3.setBackgroundResource(R.drawable.background_button_unclicked);
                break;

            case R.id.bt_topVillains:
                btContainer1.setBackgroundResource(R.drawable.background_button_unclicked);
                btContainer2.setBackgroundResource(R.drawable.background_button_clicked);
                btContainer3.setBackgroundResource(R.drawable.background_button_unclicked);
                break;

            case R.id.bt_secondTopHeroes:
                btContainer1.setBackgroundResource(R.drawable.background_button_unclicked);
                btContainer2.setBackgroundResource(R.drawable.background_button_unclicked);
                btContainer3.setBackgroundResource(R.drawable.background_button_clicked);
                break;

            default:
                Log.i("HOME SECOND FRAGMENT", "changeBackground: Bug");

        }
    }


}
