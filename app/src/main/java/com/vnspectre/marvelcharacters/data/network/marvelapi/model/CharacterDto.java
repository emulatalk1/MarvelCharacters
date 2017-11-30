package com.vnspectre.marvelcharacters.data.network.marvelapi.model;

/**
 * Created by Spectre on 11/27/17.
 */

import com.google.gson.annotations.SerializedName;

public class CharacterDto {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("modified")
    private String modified;

    @SerializedName("resourceURI")
    private String resourceUri;

//    @SerializedName("urls")
//    private List<MarvelUrl> urls;

    @SerializedName("thumbnail")
    private MarvelImage thumbnail;

//    @SerializedName("comics")
//    private MarvelResources<ComicResourceDto> comics;
//
//    @SerializedName("stories")
//    private MarvelResources<StoryResourceDto> stories;
//
//    @SerializedName("events")
//    private MarvelResources<EventResourceDto> events;
//
//    @SerializedName("series")
//    private MarvelResources<SerieResourceDto> series;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getResourceUri() {
        return resourceUri;
    }

//    public List<MarvelUrl> getUrls() {
//        return urls;
//    }

    public MarvelImage getThumbnail() {
        return thumbnail;
    }

//    public MarvelResources<ComicResourceDto> getComics() {
//        return comics;
//    }
//
//    public MarvelResources<StoryResourceDto> getStories() {
//        return stories;
//    }
//
//    public MarvelResources<EventResourceDto> getEvents() {
//        return events;
//    }
//
//    public MarvelResources<SerieResourceDto> getSeries() {
//        return series;
//    }

    @Override
    public String toString() {
        return "CharacterDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + '\''
                + ", description='"
                + description
                + '\''
                + ", modified='"
                + modified
                + '\''
                + ", resourceUri='"
                + resourceUri
                + '\''
                + ", urls="
//                + urls
                + ", thumbnail="
                + thumbnail
//                + ", comics="
//                + comics
//                + ", stories="
//                + stories
//                + ", events="
//                + events
//                + ", series="
//                + series
                +
                '}';
    }
}
