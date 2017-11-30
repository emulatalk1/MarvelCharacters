package com.vnspectre.marvelcharacters.data.network.marvelapi.entities;

/**
 * Created by Spectre on 11/28/17.
 */

public enum OrderBy {
    NAME("name"),
    MODIFIED("modified");

    private final String orderBy;

    private OrderBy(final String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return orderBy;
    }
}
