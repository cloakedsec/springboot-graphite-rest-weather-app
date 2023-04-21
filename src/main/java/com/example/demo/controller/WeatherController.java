package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class WeatherController {
    private WeatherService weatherService = new WeatherService();

    @GetMapping("/")
    public String getWeatherForm(Model model) {

        return "index";
    }

    @PostMapping("/search")
    public String getWeather(@RequestParam String city, Model model) throws IOException {
        Weather weatherResponse = weatherService.getWeather(city);

        model.addAttribute("city", weatherResponse.getCity());
        model.addAttribute("tempInCelsius1", weatherResponse.getTemperature());
        model.addAttribute("weatherResponse", weatherResponse);
        model.addAttribute("windSpeed", weatherResponse.getWindSpeed());
        model.addAttribute("visibility", weatherResponse.getVisibility());
        model.addAttribute("timezone", weatherResponse.getTimezone());
        model.addAttribute("country", weatherResponse.getCountry());
        model.addAttribute("sunrise", weatherResponse.getSunrise());
        model.addAttribute("sunset", weatherResponse.getSunset());
        model.addAttribute("longitude", weatherResponse.getLongitude());
        model.addAttribute("latitude", weatherResponse.getLatitude());
        model.addAttribute("cloudiness", weatherResponse.getCloudiness());
        model.addAttribute("pressure", weatherResponse.getPressure());
        model.addAttribute("feelsLike", weatherResponse.getFeelsLike());
        model.addAttribute("maxTemperature", weatherResponse.getMaxTemperature());
        model.addAttribute("minTemperature", weatherResponse.getMinTemperature());
        model.addAttribute("weatherIcon", weatherResponse.getWeatherIcon());
        model.addAttribute("weatherId", weatherResponse.getWeatherId());
        model.addAttribute("cityId", weatherResponse.getCityId());
        model.addAttribute("base", weatherResponse.getBase());
        model.addAttribute("dt", weatherResponse.getDt());
        model.addAttribute("cod", weatherResponse.getCod());

        return "result";
    }


    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}




