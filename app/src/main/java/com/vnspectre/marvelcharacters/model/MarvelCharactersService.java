package com.vnspectre.marvelcharacters.model;

import com.vnspectre.marvelcharacters.model.marvel.entities.CharactersDto;
import com.vnspectre.marvelcharacters.model.marvel.entities.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Spectre on 11/27/17.
 */

public interface MarvelCharactersService {

    @GET("/v1/public/characters?ts=123&apikey=b6f01aa9b460bd319570511845bbc4d4&hash=d254d25eff654ef5a2c9b5d099e67de6")
    Call<MarvelResponse<CharactersDto>> getCharacters();

}
