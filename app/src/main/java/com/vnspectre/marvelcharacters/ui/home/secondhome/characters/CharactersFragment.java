package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.data.AppDataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.BaseFragment;
import com.vnspectre.marvelcharacters.ui.home.secondhome.EndlessOnScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends BaseFragment implements CharactersMvpView, CharactersAdapter.Callback, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = CharactersFragment.class.getName();

    private CharactersAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressBar mContentLoadingProgress;

    private RecyclerView charactersRecyclerView;
    private View charactersFragment;
    private View mMessageLayout;

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
        mSwipeRefreshLayout = charactersFragment.findViewById(R.id.swipe_to_refresh);
        mContentLoadingProgress = charactersFragment.findViewById(R.id.progress);
        mMessageLayout = charactersFragment.findViewById(R.id.message_layout);

        mPresenter = new CharactersPresenter<>(AppDataManager.getInstance());
        mPresenter.onAttach(this);

        return charactersFragment;
    }

    @Override
    protected void setUp(View view) {
        //if (mAdapter == null) {
            charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            mAdapter = new CharactersAdapter(new ArrayList<CharacterDto>(0));
            mAdapter.setCallback(this);

            charactersRecyclerView.setAdapter(mAdapter);
            charactersRecyclerView.addOnScrollListener(setupScrollListener(charactersRecyclerView.getLayoutManager()));
            charactersRecyclerView.setHasFixedSize(true);

            mPresenter.onViewPrepared();

            mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorPrimaryDark);
            mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
            mSwipeRefreshLayout.setOnRefreshListener(this);
        //}
    }

    private EndlessOnScrollListener setupScrollListener(RecyclerView.LayoutManager layoutManager) {
        return new EndlessOnScrollListener((LinearLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if (mAdapter.addLoadingView(charactersRecyclerView)) {
                    mPresenter.onListEndReached(totalItemsCount, null);
                }
            }
        };
    }


    @Override
    public void showProgress() {
        if (mAdapter.isEmpty() && !mSwipeRefreshLayout.isRefreshing()) {
            mContentLoadingProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
        mContentLoadingProgress.setVisibility(View.GONE);
        mAdapter.removeLoadingView();
    }

    @Override
    public void showMessageLayout(boolean show) {
        mMessageLayout.setVisibility(show ? View.VISIBLE : View.GONE);
        charactersRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void updateCharacters(List<CharacterDto> characterList) {
//        mAdapter.updateMarvelCharacters(characterList);
        if (mAdapter.getViewType() != CharactersAdapter.VIEW_TYPE_LIST) {
            mAdapter.removeAll();
            mAdapter.setViewType(CharactersAdapter.VIEW_TYPE_LIST);
        }

        if (!mSwipeRefreshLayout.isActivated()) {
            mSwipeRefreshLayout.setEnabled(true);
        }
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

    @Override
    public void onRefresh() {
        mAdapter.removeAll();
        mPresenter.onViewPrepared();
    }
}
