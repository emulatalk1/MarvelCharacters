package com.vnspectre.marvelcharacters.data.network.marvelapi;

import com.vnspectre.marvelcharacters.data.network.marvelapi.entities.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.entities.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Spectre on 11/27/17.
 */

public interface MarvelCharactersService {

    @GET("characters")
    Call<MarvelResponse<CharactersDto>> getCharacters();

}
