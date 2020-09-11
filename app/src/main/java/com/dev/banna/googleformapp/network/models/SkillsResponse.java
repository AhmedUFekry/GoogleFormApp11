package com.dev.banna.googleformapp.network.models;

public class SkillsResponse {


    /**
     * name : Perry Oluwatobi
     * score : 277
     * country : Nigeria
     * badgeUrl : https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png
     */

    private String name;
    private int score;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
