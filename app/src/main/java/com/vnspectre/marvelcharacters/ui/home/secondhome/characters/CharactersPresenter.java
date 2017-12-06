package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import android.support.annotation.Nullable;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.data.network.RemoteCallback;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;

/**
 * Created by Spectre on 12/5/17.
 */

public class CharactersPresenter<V extends CharactersMvpView> extends BasePresenter<V> implements CharactersMvpPresenter<V> {

    private static final String TAG = CharactersPresenter.class.getName();
    private static final int ITEM_REQUEST_INITIAL_OFFSET = 0;
    private static final int ITEM_REQUEST_LIMIT = 6;

    public CharactersPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {
        getCharacters(ITEM_REQUEST_INITIAL_OFFSET, ITEM_REQUEST_LIMIT);
    }

    @Override
    public void onListEndReached(Integer offset, Integer limit) {
        getCharacters(offset, limit == null ? ITEM_REQUEST_LIMIT : limit);
    }

    private void getCharacters(int offset, int limit) {
        if (!isViewAttached()) return;
        getMvpView().showMessageLayout(false);
        getMvpView().showProgress();
        getDataManager().getMarvelCharacters(offset, limit, null, new RemoteCallback<MarvelResponse<CharactersDto>>() {
            @Override
            public void onSuccess(MarvelResponse<CharactersDto> response) {
                getMvpView().hideProgress();
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
