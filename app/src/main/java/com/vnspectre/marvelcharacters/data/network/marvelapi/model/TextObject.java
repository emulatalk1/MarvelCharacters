package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spectre on 12/1/17.
 */

public class TextObject {
    @SerializedName("type")
    private String type;

    @SerializedName("language")
    private String language;

    @SerializedName("text")
    private String text;

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }
}
