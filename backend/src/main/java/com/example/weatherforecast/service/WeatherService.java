package com.example.weatherforecast.service;

import com.example.weatherforecast.model.Weather;

public interface WeatherService {
    Weather getWeather(String cityName);

    String getCityImage(String city);
    //image
}
