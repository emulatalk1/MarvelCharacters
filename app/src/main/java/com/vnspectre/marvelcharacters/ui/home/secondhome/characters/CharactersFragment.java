package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.data.AppDataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends BaseFragment implements CharactersMvpView, CharactersAdapter.Callback {

    private static final String TAG = CharactersFragment.class.getName();

    private CharactersAdapter mAdapter;
    private RecyclerView charactersRecyclerView;
    private View charactersFragment;
    private CharactersMvpPresenter<CharactersMvpView> mPresenter;

    public CharactersFragment() {
        // Required empty public constructor
    }

    public static CharactersFragment newInstance() {
        CharactersFragment fragment = new CharactersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (charactersFragment != null) {
            return charactersFragment;
        }

        charactersFragment = inflater.inflate(R.layout.fragment_home_second_container1, container, false);

        charactersRecyclerView = charactersFragment.findViewById(R.id.recyclerView_characters_homesecond);

        mPresenter = new CharactersPresenter<>(AppDataManager.getInstance());
        mPresenter.onAttach(this);

        return charactersFragment;
    }

    @Override
    protected void setUp(View view) {
        if (mAdapter == null) {
            charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            mAdapter = new CharactersAdapter(new ArrayList<CharacterDto>(0));
            mAdapter.setCallback(this);
            charactersRecyclerView.setAdapter(mAdapter);
            mPresenter.onViewPrepared();
        }
    }

    @Override
    public void updateCharacters(List<CharacterDto> characterList) {
        mAdapter.updateMarvelCharacters(characterList);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onCharacterViewClick(String text) {
        Toast.makeText(getContext(), text + " was clicked", Toast.LENGTH_SHORT).show();
    }
}
