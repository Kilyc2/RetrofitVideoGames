package com.kiliancerdan.retrofitvideogames.Module.Game;

import com.google.gson.annotations.SerializedName;

class Video {

    private String title;
    private String uid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
