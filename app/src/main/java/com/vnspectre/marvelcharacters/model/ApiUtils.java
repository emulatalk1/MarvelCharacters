package com.vnspectre.marvelcharacters.model;

import static com.vnspectre.marvelcharacters.model.marvel.SECRET_KEYS.PRIVATE_KEY;
import static com.vnspectre.marvelcharacters.model.marvel.SECRET_KEYS.PUBLIC_KEY;

/**
 * Created by Spectre on 11/27/17.
 */

public class ApiUtils {
    public static MarvelCharactersService getMarvelCharacterService() {
        return MarvelRetrofitClient.with(PUBLIC_KEY, PRIVATE_KEY).getRetrofit().create(MarvelCharactersService.class);
    }
}
