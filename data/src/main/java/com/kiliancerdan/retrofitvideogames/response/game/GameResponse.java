package com.kiliancerdan.retrofitvideogames.response.game;

import com.google.gson.annotations.SerializedName;

public class GameResponse {

    private String name;
    private String summary;
    @SerializedName("aggregated_rating")
    private double rating;
    private int category;
    @SerializedName("first_release_date")
    private Long releaseDate;
    private CoverResponse cover;

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public double getRating() {
        return rating;
    }

    public int getCategory() {
        return category;
    }

    public Long getReleaseDate() {
        return releaseDate;
    }

    public CoverResponse getCover() {
        return cover;
    }
}
