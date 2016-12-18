package com.kiliancerdan.retrofitvideogames.response.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameResponse {

    private String id;
    private String name;
    private String summary;
    @SerializedName("aggregated_rating")
    private double rating;
    @SerializedName("first_release_date")
    private Long releaseDate;
    private List<VideoResponse> videos;
    private CoverResponse cover;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public double getRating() {
        return rating;
    }

    public Long getReleaseDate() {
        return releaseDate;
    }

    public List<VideoResponse> getVideos() {
        return videos;
    }

    public CoverResponse getCover() {
        return cover;
    }
}
