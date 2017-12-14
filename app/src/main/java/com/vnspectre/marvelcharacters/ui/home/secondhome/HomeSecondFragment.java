package com.vnspectre.marvelcharacters.ui.home.secondhome;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.ui.base.BaseFragment;

public class HomeSecondFragment extends BaseFragment{

    private static final String TAG = HomeSecondFragment.class.getName();

    private static int idFragment;

    private HomeSecondPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private Button mButtonBackFirstHome;

    private View view;

    public HomeSecondFragment() {
    }

    public static HomeSecondFragment newInstance(int id){
        HomeSecondFragment fragment = new HomeSecondFragment();
        idFragment = id;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home_second, container, false);

            mPagerAdapter = new HomeSecondPagerAdapter(getChildFragmentManager());
            mViewPager = view.findViewById(R.id.home_second_view_pager);
            mTabLayout = view.findViewById(R.id.tab_layout);

            mButtonBackFirstHome = view.findViewById(R.id.bt_backHome);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

        if (mPagerAdapter.getCount() == 0) {
            mPagerAdapter.setCount(3);

            mViewPager.setAdapter(mPagerAdapter);

            mTabLayout.addTab(mTabLayout.newTab().setText(HomeSecondPagerAdapter.CHARACTERS_TAB_STRING));
            mTabLayout.addTab(mTabLayout.newTab().setText(HomeSecondPagerAdapter.COMICS_TAB_STRING));
            mTabLayout.addTab(mTabLayout.newTab().setText(HomeSecondPagerAdapter.EVENTS_TAB_STRING));

            mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());
            mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
            mViewPager.setCurrentItem(idFragment);
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                idFragment = tab.getPosition();
                mViewPager.setCurrentItem(idFragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mButtonBackFirstHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().getmNavController().popFragment();
            }
        });

    }

//    private Button btBacktoFirstFragment;
//    private Button btContainer1;
//    private Button btContainer2;
//    private Button btContainer3;
//
//    private static int idFragment;
//
//    //Adapter.
//    private CharactersAdapter mCharactersAdapter;
//    private int mCharactersAdapterScrollPosition;
//
//    public HomeSecondFragment() {
//        // Required empty public constructor
//    }
//
//    public static HomeSecondFragment newInstance(int id) {
//        HomeSecondFragment fragment = new HomeSecondFragment();
//        idFragment = id;
//        return fragment;
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home_second, container, false);
//
//        btBacktoFirstFragment = view.findViewById(R.id.bt_backHome);
//        btContainer1 = view.findViewById(R.id.bt_secondCharacters);
//        btContainer2 = view.findViewById(R.id.bt_secondComics);
//        btContainer3 = view.findViewById(R.id.bt_secondEvents);
//
//        return view;
//    }
//
//    @Override
//    protected void setUp(View view) {
//
//        btBacktoFirstFragment.setOnClickListener(this);
//        btContainer1.setOnClickListener(this);
//        btContainer2.setOnClickListener(this);
//        btContainer3.setOnClickListener(this);
//
//        switch (idFragment) {
//            case R.id.bt_events:
//                btContainer3.callOnClick();
//                break;
//
//            case R.id.tv_sa_events:
//                btContainer3.callOnClick();
//                break;
//
//            case R.id.tv_sa_characters:
//                btContainer1.callOnClick();
//                break;
//
//            case R.id.tv_sa_comics:
//                btContainer2.callOnClick();
//                break;
//
//            default:
//                Log.d(TAG, "onCreateView: Bug at " + TAG);
//        }
//    }
//
//    @Override
//    public void onClick(View view) {
//        int item = view.getId();
//        switch (item) {
//            case R.id.bt_backHome:
//                getMainActivity().getmNavController().popFragment();
//                Log.i("Back", "onClick: back");
//                break;
//
//            case R.id.bt_secondCharacters:
//                mCharactersAdapter = getMainActivity().getmSecondHomeCharactersAdapter();
//                mCharactersAdapterScrollPosition = getMainActivity().getmSecondHomeCharactersAdapterScrollPosition();
//                if (mCharactersAdapter == null) {
//                    replace(CharactersFragment.newInstance(null, mCharactersAdapterScrollPosition));
//                } else {
//                    replace(CharactersFragment.newInstance(mCharactersAdapter, mCharactersAdapterScrollPosition));
//                }
//                idFragment = R.id.tv_sa_characters;
//                Log.i("women", "onClick: women");
//                changeBackgroundTopNavigation(btContainer1);
//                break;
//
//            case R.id.bt_secondComics:
//                replace(HomeSecondContainer2Fragment.newInstance());
//                idFragment = R.id.tv_sa_comics;
//                changeBackgroundTopNavigation(btContainer2);
//                break;
//
//            case R.id.bt_secondEvents:
//                replace(HomeSecondContainer3Fragment.newInstance());
//                idFragment = R.id.tv_sa_events;
//                changeBackgroundTopNavigation(btContainer3);
//                break;
//        }
//    }
//
//    public void replace(Fragment fragment) {
//        FragmentManager fragmentManager = getMainActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_home_second_fragment_container, fragment).commit();
//    }
//
//    private void changeBackgroundTopNavigation(Button button) {
//        int buttonId = button.getId();
//        switch (buttonId) {
//            case R.id.bt_secondCharacters:
//                btContainer1.setBackgroundResource(R.drawable.background_button_clicked);
//                btContainer2.setBackgroundResource(R.drawable.background_button_unclicked);
//                btContainer3.setBackgroundResource(R.drawable.background_button_unclicked);
//                break;
//
//            case R.id.bt_secondComics:
//                btContainer1.setBackgroundResource(R.drawable.background_button_unclicked);
//                btContainer2.setBackgroundResource(R.drawable.background_button_clicked);
//                btContainer3.setBackgroundResource(R.drawable.background_button_unclicked);
//                break;
//
//            case R.id.bt_secondEvents:
//                btContainer1.setBackgroundResource(R.drawable.background_button_unclicked);
//                btContainer2.setBackgroundResource(R.drawable.background_button_unclicked);
//                btContainer3.setBackgroundResource(R.drawable.background_button_clicked);
//                break;
//
//            default:
//                Log.i("HOME SECOND FRAGMENT", "changeBackground: Bug");
//
//        }
//    }
}
