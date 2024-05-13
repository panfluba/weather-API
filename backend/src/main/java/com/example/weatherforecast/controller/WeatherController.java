package com.example.weatherforecast.controller;

import com.example.weatherforecast.model.Weather;
import com.example.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/weather")
public class WeatherController {


    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{service}/{city}")
    public Weather getWeather(@PathVariable String service, @PathVariable String city) {
        String url;
        if ("openweathermap".equals(service)) {
            url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=4a937e62848d8d8ca5c12a35d3f83c77&units=metric";
        } else if ("weatherstack".equals(service)) {
            url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=bd925cb5139a429363e9128c569f1d22&units=metric";
//          url = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city;
        } else {
            throw new IllegalArgumentException("Invalid service name");
        }

        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(url, Weather.class);

        // Получаем URL изображения города
        String imageUrl = weatherService.getCityImage(city);
        weather.setImageUrl(imageUrl);

//        weather.setImageUrl("https://pixabay.com/api/?key=43681834-144c213b117e456418209e3cd"+ "&q=" + city + "&image_type=photo");
//        weather.setImageUrl("https://api.unsplash.com/photos/random?query=" + city + "&client_id=aHohacRDGK8PX2SeW6xpy5xLr6O1QjOdyOp9DVCywTw");
        return weather;
    }
}