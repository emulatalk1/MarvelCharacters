package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import android.util.Log;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Spectre on 12/5/17.
 */

public class CharactersPresenter<V extends CharactersMvpView> extends BasePresenter<V> implements CharactersMvpPresenter<V> {

    private static final String TAG = CharactersPresenter.class.getName();

    public CharactersPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {
        getDataManager().getMarvelCharacters(new Callback<MarvelResponse<CharactersDto>>() {
            @Override
            public void onResponse(Call<MarvelResponse<CharactersDto>> call, Response<MarvelResponse<CharactersDto>> response) {
                getMvpView().updateCharacters(response.body().getResponse().getCharacters());
            }

            @Override
            public void onFailure(Call<MarvelResponse<CharactersDto>> call, Throwable t) {
                Log.d(TAG, "onFailure: Error");
            }
        });
    }
}
