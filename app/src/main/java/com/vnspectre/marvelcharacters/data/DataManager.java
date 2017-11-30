package com.vnspectre.marvelcharacters.data;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;

import retrofit2.Callback;

/**
 * Created by Spectre on 11/30/17.
 */

public interface DataManager {

    void getCharacters(Callback<MarvelResponse<CharactersDto>> listener);

}
