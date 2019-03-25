package com.nan.tutor.bean;

/**
 * Created by nan on 2019/3/25.
 */
public class Institution {
    private String image;
    private String name;
    private double mark;
    private double dist;

    public Institution(String image, String name, double mark, double dist) {
        this.image = image;
        this.name = name;
        this.mark = mark;
        this.dist = dist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }
}
