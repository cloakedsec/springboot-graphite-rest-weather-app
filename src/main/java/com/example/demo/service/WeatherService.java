package com.example.demo.service;

import com.example.demo.model.Weather;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate restTemplate = new RestTemplate();
    private String apiKey = "c407374f1d9a95f448957d19768bddec";

    public Weather getWeather(String city) {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(response);
        System.out.println(url);

        System.out.println(jsonObject);
        String result = jsonObject.toString();
        System.out.println(result);
        Weather weather = new Weather();
        weather.setCity(city);

        System.out.println(city);

        weather.setTemperature(jsonObject.getJSONObject("main").getDouble("temp"));
        weather.setHumidity(jsonObject.getJSONObject("main").getDouble("humidity"));
        weather.setDescription(jsonObject.getJSONArray("weather").getJSONObject(0).getString("description"));

        return weather;
    }
}
