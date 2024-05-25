package com.example.aniphonicsapp.Matching_Sound;

public class Sound {
    private int imageResourceId;
    private int soundResourcesId;

    public Sound(int imageResourceId, int soundResourcesId) {
        this.imageResourceId = imageResourceId;
        this.soundResourcesId = soundResourcesId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSoundResourcesId() {
        return soundResourcesId;
    }
}