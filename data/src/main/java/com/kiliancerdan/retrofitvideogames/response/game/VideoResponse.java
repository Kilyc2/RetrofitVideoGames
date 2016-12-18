package com.kiliancerdan.retrofitvideogames.response.game;


import com.google.gson.annotations.SerializedName;

public class VideoResponse {

    private String name;
    @SerializedName("video_id")
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
