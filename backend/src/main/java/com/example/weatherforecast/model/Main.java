package com.example.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    @JsonProperty("temp")
    private double temperature;
    private double humidity;

    public Main(double temperature, double humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }
    public Main(){
        this.temperature = 0;
        this.humidity = 0;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
