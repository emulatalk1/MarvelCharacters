package com.vnspectre.marvelcharacters.ui.home.firsthome;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.ui.base.MvpView;

import java.util.List;

/**
 * Created by Spectre on 11/30/17.
 */

public interface HomeFirstMvpView extends MvpView {

    void updateCharacters(List<CharacterDto> characterList);

}
