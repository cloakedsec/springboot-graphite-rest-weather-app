package com.example.demo.service;

import com.example.demo.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
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

        weather.setCity(jsonObject.getString("name"));

        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weatherObject = weatherArray.getJSONObject(0);
        weather.setDescription(weatherObject.getString("description"));

        JSONObject windObject = jsonObject.getJSONObject("wind");
        weather.setWindSpeed(windObject.getDouble("speed"));

        double tempInKelvin = jsonObject.getJSONObject("main").getDouble("temp");
        double tempInCelsius = tempInKelvin - 273.15;
        weather.setTemperature((int) Math.floor(tempInCelsius));

        weather.setHumidity(jsonObject.getJSONObject("main").getDouble("humidity"));
        weather.setVisibility((int)jsonObject.getDouble("visibility"));
        weather.setTimezone((int)jsonObject.getDouble("timezone"));

        JSONObject sysObject = jsonObject.getJSONObject("sys");
        weather.setCountry(sysObject.getString("country"));
        weather.setSunrise(sysObject.getLong("sunrise"));
        weather.setSunset(sysObject.getLong("sunset"));

        JSONObject coordObject = jsonObject.getJSONObject("coord");
        weather.setLongitude(coordObject.getDouble("lon"));
        weather.setLatitude(coordObject.getDouble("lat"));

        weather.setCloudiness((int)jsonObject.getJSONObject("clouds").getDouble("all"));
        weather.setPressure((int)jsonObject.getJSONObject("main").getDouble("pressure"));
        weather.setFeelsLike((int) Math.floor(jsonObject.getJSONObject("main").getDouble("feels_like")));
        weather.setMaxTemperature((int) Math.floor(jsonObject.getJSONObject("main").getDouble("temp_max")));
        weather.setMinTemperature((int) Math.floor(jsonObject.getJSONObject("main").getDouble("temp_min")));

        weather.setWeatherIcon(weatherObject.getString("icon"));
        weather.setWeatherId(weatherObject.getInt("id"));
        weather.setCityId(jsonObject.getInt("id"));
        weather.setBase(jsonObject.getString("base"));
        weather.setDt(jsonObject.getLong("dt"));
        weather.setCod(jsonObject.getInt("cod"));

//        weather.setCity(city);
//
//        weather.setDescription(jsonObject.getJSONArray("weather").getJSONObject(0).getString("description"));
//        JSONObject windObject = jsonObject.getJSONObject("wind");
//        weather.setWindSpeed(windObject.getDouble("speed"));
//        double tempInKelvin = jsonObject.getJSONObject("main").getDouble("temp");
//        double tempInCelsius = tempInKelvin - 273.15;
//
//        weather.setTemperature((int) Math.floor(tempInCelsius));
//        weather.setHumidity(jsonObject.getJSONObject("main").getDouble("humidity"));


        return weather;
    }
}






