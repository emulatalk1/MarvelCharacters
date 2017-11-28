package com.vnspectre.marvelcharacters.model.marvel.entities;

/**
 * Created by Spectre on 11/27/17.
 */

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class MarvelCollection<T> {
    @SerializedName("offset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<T> results = new ArrayList<>();

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    protected List<T> getResults() {
        return results;
    }
}
