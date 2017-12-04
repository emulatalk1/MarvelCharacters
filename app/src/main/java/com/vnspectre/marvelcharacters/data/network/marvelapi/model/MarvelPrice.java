package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

/**
 * Created by Spectre on 12/1/17.
 */

import com.google.gson.annotations.SerializedName;

public class MarvelPrice {
    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private float price;

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}
