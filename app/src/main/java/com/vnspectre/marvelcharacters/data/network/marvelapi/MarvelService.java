package com.vnspectre.marvelcharacters.data.network.marvelapi;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Spectre on 11/27/17.
 */

public interface MarvelService {

    @GET("characters")
    Call<MarvelResponse<CharactersDto>> getCharacters();

}
