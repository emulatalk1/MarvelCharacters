package com.vnspectre.marvelcharacters.ui.home.firsthome;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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

    private Button btTopHeroes;
    private TextView totalCharacters;
    private CharactersAdapter mAdapter;
    private RecyclerView charactersRecyclerView;

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
        View homeFirst = inflater.inflate(R.layout.fragment_home_first, container, false);

        totalCharacters = homeFirst.findViewById(R.id.tv_totalCharacters);
        btTopHeroes = homeFirst.findViewById(R.id.bt_topHeroes);
        charactersRecyclerView = homeFirst.findViewById(R.id.recylerView_characters);

        mPresenter = new HomeFirstPresenter<>(AppDataManager.getInstance());
        mPresenter.onAttach(this);

        return homeFirst;
    }

    @Override
    protected void setUp(View view) {
        charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new CharactersAdapter(new ArrayList<CharacterDto>(0));
        mAdapter.setCallback(this);

        btTopHeroes.setOnClickListener(this);

        charactersRecyclerView.setAdapter(mAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_topHeroes:
                getMainActivity().getmNavController().pushFragment(HomeSecondFragment.newInstance());
                break;
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
