package com.example.aniphonicsapp.Matching_Name;

public class Picture {
    private int imageResourceId;
    private int imageNameResourcesId;
    private int soundNameResourceId;

    public Picture(int imageResourceId, int imageNameResourcesId, int soundNameResourceId) {
        this.imageResourceId = imageResourceId;
        this.imageNameResourcesId = imageNameResourcesId;
        this.soundNameResourceId = soundNameResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getImageResourcesIdName() {
        return imageNameResourcesId;
    }

    public int getSoundNameResourceId() { return soundNameResourceId;}
}