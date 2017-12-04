package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spectre on 12/1/17.
 */

public class MarvelUrl {
    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override public String toString() {
        return "MarvelUrl{" + "type='" + type + '\'' + ", url='" + url + '\'' + '}';
    }
}
