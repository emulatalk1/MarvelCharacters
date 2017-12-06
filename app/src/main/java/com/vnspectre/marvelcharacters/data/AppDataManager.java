package com.vnspectre.marvelcharacters.data;

import com.vnspectre.marvelcharacters.data.network.RemoteCallback;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;
import com.vnspectre.marvelcharacters.data.repository.MarvelRepository;

import retrofit2.Callback;

/**
 * Created by Spectre on 11/30/17.
 */

public class AppDataManager implements DataManager {

    private static AppDataManager sInstance;

    private MarvelRepository mMarvelRepository;

    public static AppDataManager getInstance() {
        if (sInstance == null) {
            sInstance = new AppDataManager(MarvelRepository.getInstance());
        }
        return sInstance;
    }

    private AppDataManager(MarvelRepository mMarvelRepository) {
        this.mMarvelRepository = mMarvelRepository;
    }

    @Override
    public void getMarvelCharacters(int offSet, int limit, final String searchQuery, RemoteCallback<MarvelResponse<CharactersDto>> listener) {
        mMarvelRepository.getCharacters(offSet, limit, searchQuery, listener);
    }
}
