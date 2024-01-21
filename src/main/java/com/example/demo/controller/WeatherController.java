package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WeatherController {
    private WeatherService weatherService = new WeatherService();

    @GetMapping("/weather")
    public String getWeatherForm(Model model) {

        return "index";
    }

    @PostMapping("/search")
    public String getWeather(@RequestParam String city, Model model) throws IOException {
        Weather weatherResponse = weatherService.getWeather(city);

        Map<String, Object> weatherAttributes = new HashMap<>();
        weatherAttributes.put("city", weatherResponse.getCity());
        weatherAttributes.put("tempInCelsius1", weatherResponse.getTemperature());
        weatherAttributes.put("weatherResponse", weatherResponse);
        weatherAttributes.put("windSpeed", weatherResponse.getWindSpeed());
        weatherAttributes.put("visibility", weatherResponse.getVisibility());
        weatherAttributes.put("timezone", weatherResponse.getTimezone());
        weatherAttributes.put("country", weatherResponse.getCountry());
        weatherAttributes.put("sunrise", weatherResponse.getSunrise());
        weatherAttributes.put("sunset", weatherResponse.getSunset());
        weatherAttributes.put("longitude", weatherResponse.getLongitude());
        weatherAttributes.put("latitude", weatherResponse.getLatitude());
        weatherAttributes.put("cloudiness", weatherResponse.getCloudiness());
        weatherAttributes.put("pressure", weatherResponse.getPressure());
        weatherAttributes.put("feelsLike", weatherResponse.getFeelsLike());
        weatherAttributes.put("maxTemperature", weatherResponse.getMaxTemperature());
        weatherAttributes.put("minTemperature", weatherResponse.getMinTemperature());
        weatherAttributes.put("weatherIcon", weatherResponse.getWeatherIcon());
        weatherAttributes.put("weatherId", weatherResponse.getWeatherId());
        weatherAttributes.put("cityId", weatherResponse.getCityId());
        weatherAttributes.put("base", weatherResponse.getBase());
        weatherAttributes.put("dt", weatherResponse.getDt());
        weatherAttributes.put("cod", weatherResponse.getCod());

        model.addAllAttributes(weatherAttributes);
        return "result";
    }

    @GetMapping("/search")
    public String search(@RequestParam("city") String city, Model model) throws IOException {
        Weather weatherResponse = weatherService.getWeather(city);
        if (weatherResponse == null) {
            model.addAttribute("error", "Error retrieving weather information");
            return "error";
        }
            if (city == "" || city == null)
                return "error";
            model.addAttribute("weather", weatherResponse);
            return "result";
        }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }




}




