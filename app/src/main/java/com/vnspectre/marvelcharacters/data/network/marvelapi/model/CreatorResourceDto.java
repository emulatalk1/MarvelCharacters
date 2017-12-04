package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

/**
 * Created by Spectre on 12/1/17.
 */

import com.google.gson.annotations.SerializedName;

public class CreatorResourceDto extends MarvelResourceDto {
    @SerializedName("role")
    private String role;

    public String getRole() {
        return role;
    }
}
