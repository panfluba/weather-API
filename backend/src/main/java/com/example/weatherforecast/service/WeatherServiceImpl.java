package com.example.weatherforecast.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.weatherforecast.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${Key-for-java}")
    private String apiKey;


    public Weather getWeather(String cityName) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + "bd925cb5139a429363e9128c569f1d22" + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(url, Weather.class);

        String pixabayUrl = "https://pixabay.com/api/?key=43681834-144c213b117e456418209e3cd" + "&q=" + cityName + "&image_type=photo";
        String imageUrl = restTemplate.getForObject(pixabayUrl, String.class);


//        weather.setImageUrl("https://pixabay.com/api/?key=43681834-144c213b117e456418209e3cd"+ "&q=" + cityName + "&image_type=photo");
//        weather.setImageUrl("http://api.unsplash.com/photos/random?query=" + cityName + "&client_id=aHohacRDGK8PX2SeW6xpy5xLr6O1QjOdyOp9DVCywTw");

        return weather;
    }

    public String getCityImage(String city) {
        String url = "https://pixabay.com/api/?key=43681834-144c213b117e456418209e3cd" + "&q=" + city + "&image_type=photo";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Извлекаем webformatURL из JSON
        String webformatURL = null;
        if (response != null) {
            int startIndex = response.indexOf("webformatURL\":\"") + "webformatURL\":\"".length();
            int endIndex = response.indexOf("\"", startIndex);
            if (startIndex != -1 && endIndex != -1) {
                webformatURL = response.substring(startIndex, endIndex);
            }
        }

        return webformatURL;
    }
}


