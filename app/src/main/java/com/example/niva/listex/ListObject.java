package com.example.niva.listex;

/**
 * Created by Niva on 05/06/2016.
 */
public class ListObject {
    private String title, description;
    private int img;

    public ListObject(String title, String description, int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }
}
