package com.vnspectre.marvelcharacters.data;

import com.vnspectre.marvelcharacters.data.network.AppApiHelper;
import com.vnspectre.marvelcharacters.data.network.marvelapi.MarvelService;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;

import retrofit2.Callback;

/**
 * Created by Spectre on 11/30/17.
 */

public class AppDataManager implements DataManager{

    private static AppDataManager sInstance;

    private final MarvelService mMarvelService;

    public static AppDataManager getInstance() {
        if (sInstance == null) {
            sInstance = new AppDataManager();
        }
        return sInstance;
    }

    private AppDataManager() {
        mMarvelService = AppApiHelper.getMarvelCharacterService();
    }


    @Override
    public void getCharacters(Callback<MarvelResponse<CharactersDto>> listener) {
        mMarvelService.getCharacters().enqueue(listener);
    }
}
