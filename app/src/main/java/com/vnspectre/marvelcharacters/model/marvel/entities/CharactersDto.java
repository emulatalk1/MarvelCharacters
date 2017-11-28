package com.vnspectre.marvelcharacters.model.marvel.entities;

/**
 * Created by Spectre on 11/27/17.
 */

import java.util.List;

public class CharactersDto extends MarvelCollection<CharacterDto> {

    public List<CharacterDto> getCharacters() {
        return getResults();
    }

    @Override
    public String toString() {
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
                + getCharacters().toString()
                + '}';
    }
}
