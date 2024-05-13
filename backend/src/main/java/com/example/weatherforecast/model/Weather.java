package com.example.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Weather {
    private String name;
    private Main main;

    private String imageUrl;

    public Weather() {}

    public Weather(String name, Main main) {
        this.name = name;
        this.main = main;
    }

    public Weather(String name, Main main, String imageUrl) {
        this.name = name;
        this.main = main;
        this.imageUrl = imageUrl;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}