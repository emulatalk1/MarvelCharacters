package com.vnspectre.marvelcharacters.ui.home.firsthome;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.data.network.RemoteCallback;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;


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

        if (!isViewAttached()) return;

        getDataManager().getMarvelCharacters(0, 21, null, new RemoteCallback<MarvelResponse<CharactersDto>>() {
            @Override
            public void onSuccess(MarvelResponse<CharactersDto> response) {
                getMvpView().updateCharacters(response.getResponse().getCharacters());
            }

            @Override
            public void onUnauthorized() {
                
            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });
    }
}
