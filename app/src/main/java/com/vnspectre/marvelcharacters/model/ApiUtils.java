package com.vnspectre.marvelcharacters.model;

/**
 * Created by Spectre on 11/27/17.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://gateway.marvel.com:443";
    public static MarvelCharactersService getMCService() {
        return RetrofitClient.getClient(BASE_URL).create(MarvelCharactersService.class);
    }
}
