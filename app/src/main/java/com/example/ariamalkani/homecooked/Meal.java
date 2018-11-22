package com.example.ariamalkani.homecooked;

import java.util.List;

public class Meal {
    private String chefName;
    private Boolean verified;
    private Boolean vegan;
    private String rating;
    private String avgPrice;
    private int thumbnail;

    public Meal() { }

    public Meal(String chefName, Boolean verified, Boolean vegan,
                String rating, String avgPrice, int thumbnail) {
        this.chefName = chefName;
        this.verified = verified;
        this.vegan = vegan;
        this.rating = rating;
        this.avgPrice = avgPrice;
        this.thumbnail = thumbnail;
    }

    //  Getters
    public String getChefName() {
        return this.chefName;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public String getRating() {
        return rating;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    // Setters

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

