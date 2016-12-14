package com.kiliancerdan.retrofitvideogames.response.game;

import com.google.gson.annotations.SerializedName;

public class CoverResponse {

    @SerializedName("cloudinary_id")
    private String id;
    private int width;
    private int height;

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
