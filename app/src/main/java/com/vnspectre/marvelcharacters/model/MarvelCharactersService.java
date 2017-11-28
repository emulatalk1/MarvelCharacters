package com.vnspectre.marvelcharacters.model;

import com.vnspectre.marvelcharacters.model.marvel.entities.CharactersDto;
import com.vnspectre.marvelcharacters.model.marvel.entities.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Spectre on 11/27/17.
 */

public interface MarvelCharactersService {

    @GET("characters")
    Call<MarvelResponse<CharactersDto>> getCharacters();

}
