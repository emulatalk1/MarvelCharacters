package com.vnspectre.marvelcharacters.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.vnspectre.marvelcharacters.activity.MainActivity;
import com.vnspectre.marvelcharacters.model.ApiUtils;
import com.vnspectre.marvelcharacters.model.MarvelCharactersService;
import com.vnspectre.marvelcharacters.model.marvel.entities.CharactersDto;
import com.vnspectre.marvelcharacters.model.marvel.entities.MarvelResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFirstFragment extends Fragment implements OnClickListener, HomeFirstCharactersAdapter.HomeFirstCharactersAdapterOnClickHandler{

    private Button btTopHeroes;
    private TextView totalCharacters;
    private MarvelCharactersService marvelService;
    private HomeFirstCharactersAdapter mAdapter;

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

        totalCharacters = homeFirst.findViewById(R.id.tv_totalCharacters);
        btTopHeroes = homeFirst.findViewById(R.id.bt_topHeroes);
        btTopHeroes.setOnClickListener(this);

        RecyclerView charactersRecyclerView = homeFirst.findViewById(R.id.recylerView_characters);
        charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        marvelService = ApiUtils.getMarvelCharacterService();
        mAdapter = new HomeFirstCharactersAdapter(new ArrayList<CharactersDto>(0), this);

        charactersRecyclerView.setAdapter(mAdapter);

        loadMarvelCharacters();

        return homeFirst;
    }

    public void loadMarvelCharacters() {
        marvelService.getCharacters().enqueue(new Callback<MarvelResponse<CharactersDto>>() {
            @Override
            public void onResponse(Call<MarvelResponse<CharactersDto>> call, Response<MarvelResponse<CharactersDto>> response) {
                mAdapter.updateMarvelCharacters(response.body().getResponse().getCharacters());
                totalCharacters.setText(String.format("(%s)", String.valueOf(response.body().getResponse().getCharacters().size())));
            }

            @Override
            public void onFailure(Call<MarvelResponse<CharactersDto>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_topHeroes:
                ((MainActivity) getActivity()).getmNavController().pushFragment(HomeSecondFragment.newInstance());
                break;
        }
    }

    @Override
    public void onClickCharacterAdapter(String selectedCharacterName) {
        Toast.makeText(getContext(), selectedCharacterName + " selected", + Toast.LENGTH_SHORT).show();
    }
}
