package com.vnspectre.marvelcharacters.ui.detail.characters;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.data.AppDataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.BaseFragment;
import com.vnspectre.marvelcharacters.utils.CircleTransform;

/**
 * Created by Spectre on 12/12/17.
 */

public class CharacterDetailFragment extends BaseFragment implements CharacterDetailMvpView {

    private static final String TAG = CharacterDetailFragment.class.getName();

    private static CharacterDto mCharacter;

    private View mCharacterDetailFragment;

    private ImageView mHeaderCoverImage;
    private ImageView mCharacterProfilePhoto;
//    private TextView mCharacterProfileName;
    private TextView mCharacterProfileDes;

    private CollapsingToolbarLayout mCollapsingToolbar;
    private Toolbar mToolbar;

    private CharacterDetailPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private CharacterDetailMvpPresenter<CharacterDetailMvpView> mPresenter;
    private int idFragment = 0;

    public CharacterDetailFragment() {

    }

    public static CharacterDetailFragment newInstance(CharacterDto character) {
        CharacterDetailFragment fragment = new CharacterDetailFragment();
        mCharacter = character;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mCharacterDetailFragment == null) {
            mCharacterDetailFragment = inflater.inflate(R.layout.fragment_character_detail, container, false);

            mHeaderCoverImage = mCharacterDetailFragment.findViewById(R.id.header_cover_image);
            mCharacterProfilePhoto = mCharacterDetailFragment.findViewById(R.id.character_profile_photo);
//            mCharacterProfileName = mCharacterDetailFragment.findViewById(R.id.character_profile_name);
            mCharacterProfileDes = mCharacterDetailFragment.findViewById(R.id.character_profile_des);

            mCollapsingToolbar = mCharacterDetailFragment.findViewById(R.id.collapsing_toolbar);
            mToolbar = mCharacterDetailFragment.findViewById(R.id.toolbar);

            getMainActivity().setSupportActionBar(mToolbar);
            getMainActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mPagerAdapter = new CharacterDetailPagerAdapter(getChildFragmentManager());
            mViewPager = mCharacterDetailFragment.findViewById(R.id.detail_view_pager);
            mTabLayout = mCharacterDetailFragment.findViewById(R.id.detail_tab_layout);

            mPresenter = new CharacterDetailPresenter<>(AppDataManager.getInstance());
            mPresenter.onAttach(this);
        }
        return mCharacterDetailFragment;
    }

    @Override
    protected void setUp(View view) {
        mPresenter.onViewPrepared();
        if (mPagerAdapter.getCount() == 0) {
            mPagerAdapter.setCount(3);

            mViewPager.setAdapter(mPagerAdapter);

            mTabLayout.addTab(mTabLayout.newTab().setText(CharacterDetailPagerAdapter.BIO_TAB_STRING));
            mTabLayout.addTab(mTabLayout.newTab().setText(CharacterDetailPagerAdapter.COMICS_TAB_STRING));
            mTabLayout.addTab(mTabLayout.newTab().setText(CharacterDetailPagerAdapter.EVENTS_TAB_STRING));

            mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());
            mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
            mViewPager.setCurrentItem(idFragment);
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: " + idFragment);
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


    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public CharacterDto getCharacter() {
        return mCharacter;
    }

    @Override
    public void updateView(String characterCoverImage, String characterProfilePhoto, String characterName, String characterDes) {
        Picasso.with(mHeaderCoverImage.getContext()).load(characterCoverImage).into(mHeaderCoverImage);
        Picasso.with(mCharacterProfilePhoto.getContext())
                .load(characterProfilePhoto)
                .transform(new CircleTransform())
                .into(mCharacterProfilePhoto);
        //mCharacterProfileName.setText(characterName);

        mCollapsingToolbar.setTitle(characterName);
        mCharacterProfileDes.setText(characterDes);
    }


    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
