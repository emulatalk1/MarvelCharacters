package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

/**
 * Created by Spectre on 12/1/17.
 */

import com.google.gson.annotations.SerializedName;

public class MarvelDate {
    @SerializedName("type")
    private String type;

    @SerializedName("date")
    private String date;

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
