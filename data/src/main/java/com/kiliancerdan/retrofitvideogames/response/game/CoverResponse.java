package com.kiliancerdan.retrofitvideogames.response.game;

import com.google.gson.annotations.SerializedName;

public class CoverResponse {

    @SerializedName("cloudinary_id")
    private String id;

    public String getId() {
        return id;
    }
}
