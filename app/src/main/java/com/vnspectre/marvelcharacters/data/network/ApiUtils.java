package com.vnspectre.marvelcharacters.data.network;

import com.vnspectre.marvelcharacters.data.network.marvelapi.MarvelCharactersService;
import com.vnspectre.marvelcharacters.data.network.marvelapi.MarvelRetrofitClient;
import com.vnspectre.marvelcharacters.data.network.marvelapi.SECRET_KEYS;


/**
 * Created by Spectre on 11/27/17.
 */

public class ApiUtils {
    public static MarvelCharactersService getMarvelCharacterService() {
        return MarvelRetrofitClient.with(SECRET_KEYS.PUBLIC_KEY, SECRET_KEYS.PRIVATE_KEY).getRetrofit().create(MarvelCharactersService.class);
    }
}
