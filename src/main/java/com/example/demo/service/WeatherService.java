package com.example.demo.service;

import com.example.demo.model.Weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class WeatherService {


    private RestTemplate restTemplate = new RestTemplate();
    private String apiKey = "c407374f1d9a95f448957d19768bddec";

    public Weather getWeather(String city) throws IOException {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(response);
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(jsonObject);
        Weather weather = new Weather();
        weather.setCity(city);

        weather.setDescription(jsonObject.getJSONArray("weather").getJSONObject(0).getString("description"));
        JSONObject windObject = jsonObject.getJSONObject("wind");
        weather.setWindSpeed(windObject.getDouble("speed"));
        double tempInKelvin = jsonObject.getJSONObject("main").getDouble("temp");
        double tempInCelsius = tempInKelvin - 273.15;

        weather.setTemperature((int) Math.floor(tempInCelsius));
        weather.setHumidity(jsonObject.getJSONObject("main").getDouble("humidity"));
//        weather.setTemperature(jsonObject.getJSONObject("main").getDouble("temp"));

        return weather;
    }
}






