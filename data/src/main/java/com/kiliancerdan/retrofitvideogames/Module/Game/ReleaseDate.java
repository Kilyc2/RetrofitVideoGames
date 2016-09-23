package com.kiliancerdan.retrofitvideogames.Module.Game;


import com.google.gson.annotations.SerializedName;

class ReleaseDate {

    @SerializedName("platform_name")
    private String platformName;
    @SerializedName("release_date")
    private String releaseDate;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
