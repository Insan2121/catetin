package com.example.catetin.model;

public class ScreenItem {

    public ScreenItem(int apps, int smartphone) {
    }

    public ScreenItem(String description, int screenImage) {
        this.description = description;
        this.screenImage = screenImage;
    }

    String description;
    int screenImage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScreenImage() {
        return screenImage;
    }

    public void setScreenImage(int screenImage) {
        this.screenImage = screenImage;
    }
}
