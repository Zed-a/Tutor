package com.nan.tutor.bean;

/**
 * Created by nan on 2019/3/20.
 */
public class Teacher {
    private int image;
    private String name;
    private String description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Teacher(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Teacher(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
