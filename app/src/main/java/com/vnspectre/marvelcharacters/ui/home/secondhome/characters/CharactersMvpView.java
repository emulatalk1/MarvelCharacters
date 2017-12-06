package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.MvpView;

import java.util.List;

/**
 * Created by Spectre on 12/5/17.
 */

public interface CharactersMvpView extends MvpView {
    void showProgress();

    void hideProgress();

    void showMessageLayout(boolean show);

    void updateCharacters(List<CharacterDto> characterList);
}
