package com.vnspectre.marvelcharacters.data.network.marvelapi;

import android.support.annotation.Nullable;

import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharactersDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Spectre on 11/27/17.
 */

public interface MarvelService {

    @GET("characters")
    Call<MarvelResponse<CharactersDto>> getCharacters(@Nullable @Query("offset") Integer offset,
                                                      @Nullable @Query("limit") Integer limit,
                                                      @Nullable @Query("nameStartsWith") String searchQuery);

    @GET("characters/{characterId}")
    Call<MarvelResponse<CharactersDto>> getCharacter(@Path("characterId") long characterId);

}
