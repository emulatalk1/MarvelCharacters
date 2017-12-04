package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spectre on 12/1/17.
 */

public class MarvelResourceDto {
    @SerializedName("resourceURI")
    private String resourceUri;

    @SerializedName("name")
    private String name;

    public String getResourceUri() {
        return resourceUri;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "MarvelResourceDto{"
                + "resourceUri='"
                + resourceUri
                + '\''
                + ", name='"
                + name
                + '\''
                + '}';
    }
}
