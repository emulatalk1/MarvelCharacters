package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spectre on 12/1/17.
 */

public class StoryResourceDto extends MarvelResourceDto {
    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    @Override public String toString() {
        return "StoryResourceDto{"
                + "name="
                + super.getName()
                + "resourceUri="
                + super.getResourceUri()
                + "type='"
                + type
                + '\''
                +
                '}';
    }
}
