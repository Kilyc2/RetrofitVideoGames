package com.kiliancerdan.retrofitvideogames.module.game;

public class Cover {

    private String id;
    private int width;
    private int height;

    public Cover() {
        this.id = "";
        this.width = 0;
        this.height = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
