package com.vnspectre.marvelcharacters.ui.home.firsthome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.data.AppDataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.BaseFragment;
import com.vnspectre.marvelcharacters.ui.home.secondhome.HomeSecondFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFirstFragment extends BaseFragment implements HomeFirstMvpView, OnClickListener, CharactersAdapter.Callback {

    private static final String TAG = HomeFirstFragment.class.getName();

    private Button btEvents;
    private TextView totalCharacters;
    private CharactersAdapter mAdapter;
    private RecyclerView charactersRecyclerView;
    private View homeFirst;

    private TextView saCharacters;
    private TextView saComics;
    private TextView saEvents;

    private HomeFirstMvpPresenter<HomeFirstMvpView> mPresenter;

    public HomeFirstFragment() {
    }

    public static HomeFirstFragment newInstance() {
        HomeFirstFragment fragment = new HomeFirstFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (homeFirst != null) {
            return homeFirst;
        }

        homeFirst = inflater.inflate(R.layout.fragment_home_first, container, false);

        totalCharacters = homeFirst.findViewById(R.id.tv_totalCharacters);
        btEvents = homeFirst.findViewById(R.id.bt_events);
        charactersRecyclerView = homeFirst.findViewById(R.id.recylerView_characters);
        saCharacters = homeFirst.findViewById(R.id.tv_sa_characters);
        saComics = homeFirst.findViewById(R.id.tv_sa_comics);
        saEvents = homeFirst.findViewById(R.id.tv_sa_events);

        mPresenter = new HomeFirstPresenter<>(AppDataManager.getInstance());
        mPresenter.onAttach(this);

        return homeFirst;
    }

    @Override
    protected void setUp(View view) {
        if (mAdapter == null) {
            charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            mAdapter = new CharactersAdapter(new ArrayList<CharacterDto>(0));
            mAdapter.setCallback(this);
            charactersRecyclerView.setAdapter(mAdapter);
            mPresenter.onViewPrepared();
            btEvents.setOnClickListener(this);
            saCharacters.setOnClickListener(this);
            saComics.setOnClickListener(this);
            saEvents.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_events:
                getMainActivity().getmNavController().pushFragment(HomeSecondFragment.newInstance(R.id.bt_events));
                break;

            case R.id.tv_sa_characters:
                getMainActivity().getmNavController().pushFragment(HomeSecondFragment.newInstance(R.id.tv_sa_characters));
                Log.d(TAG, "onClick: see all characters");
                break;

            case R.id.tv_sa_comics:
                getMainActivity().getmNavController().pushFragment(HomeSecondFragment.newInstance(R.id.tv_sa_comics));
                break;

            case R.id.tv_sa_events:
                getMainActivity().getmNavController().pushFragment(HomeSecondFragment.newInstance(R.id.tv_sa_events));
                break;

            default:
                Log.d(TAG, "onClick: Bug at" + TAG);
        }
    }

    @Override
    public void onCharacterViewClick(String text) {
        Toast.makeText(getContext(), text + " was clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateCharacters(List<CharacterDto> characterList) {
        mAdapter.updateMarvelCharacters(characterList);
        totalCharacters.setText(String.format("(%s)", String.valueOf(characterList.size())));
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
