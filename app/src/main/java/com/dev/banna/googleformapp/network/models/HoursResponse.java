package com.dev.banna.googleformapp.network.models;

/**
 * Created By Mohamed El Banna On 4/5/2020
 **/
public class HoursResponse {

    /**
     * name : Kojo Yeboah
     * hours : 55
     * country : Ghana
     * badgeUrl : https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png
     */

    private String name;
    private int hours;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
