package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

import java.util.List;

/**
 * Created by Spectre on 12/1/17.
 */

public class ComicsDto extends MarvelCollection<ComicDto> {

    public List<ComicDto> getComics() {
        return getResults();
    }

    @Override public String toString() {
        return "CharactersDto{"
                + "offset="
                + getOffset()
                + ", limit="
                + getLimit()
                + ", total="
                + getTotal()
                + ", count="
                + getCount()
                + ", characters="
                + getComics().toString()
                + '}';
    }
}
