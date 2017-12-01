package com.vnspectre.marvelcharacters.data.repository;

import com.vnspectre.marvelcharacters.data.network.marvelapi.MarvelClient;
import com.vnspectre.marvelcharacters.data.network.marvelapi.MarvelService;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;

import retrofit2.Callback;

/**
 * Created by Spectre on 12/1/17.
 */

public class MarvelRepository {

    private static MarvelRepository sInstance;

    private final MarvelService mMarvelService;

    public static MarvelRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MarvelRepository();
        }
        return sInstance;
    }

    private MarvelRepository() {
        mMarvelService = MarvelClient.getMarvelCharacterService();
    }

    public void getCharacters(Callback<MarvelResponse<CharactersDto>> listener) {
        mMarvelService.getCharacters().enqueue(listener);
    }

}
