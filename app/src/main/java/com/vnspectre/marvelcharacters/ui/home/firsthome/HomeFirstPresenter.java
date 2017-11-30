package com.vnspectre.marvelcharacters.ui.home.firsthome;

import android.util.Log;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Spectre on 11/30/17.
 */

public class HomeFirstPresenter<V extends HomeFirstMvpView> extends BasePresenter<V> implements HomeFirstMvpPresenter<V> {

    private final String TAG = "HomeFirstPresenter";

    public HomeFirstPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {
        getDataManager().getCharacters(new Callback<MarvelResponse<CharactersDto>>() {
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
