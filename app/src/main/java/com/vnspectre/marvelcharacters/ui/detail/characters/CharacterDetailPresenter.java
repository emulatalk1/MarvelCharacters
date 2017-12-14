package com.vnspectre.marvelcharacters.ui.detail.characters;

import com.vnspectre.marvelcharacters.data.DataManager;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.BasePresenter;

import static com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelImage.Size.LANDSCAPE_INCREDIBLE;
import static com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelImage.Size.PORTRAIT_XLARGE;

/**
 * Created by Spectre on 12/12/17.
 */

public class CharacterDetailPresenter<V extends CharacterDetailMvpView> extends BasePresenter<V> implements CharacterDetailMvpPresenter<V> {

    public CharacterDetailPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {
        if (!isViewAttached()) return;
        CharacterDto character = getMvpView().getCharacter();
        getMvpView().updateView(
                character.getThumbnail().getImageUrl(LANDSCAPE_INCREDIBLE),
                character.getThumbnail().getImageUrl(PORTRAIT_XLARGE),
                character.getName());
//                character.getDescription());
    }

}
