package com.vnspectre.marvelcharacters.ui.detail.characters;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.MvpView;

/**
 * Created by Spectre on 12/12/17.
 */

public interface CharacterDetailMvpView extends MvpView {
    CharacterDto getCharacter();
    void updateView(String characterCoverImage, String characterProfilePhoto, String characterName, String characterDes);
}
