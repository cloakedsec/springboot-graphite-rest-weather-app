package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    private WeatherService weatherService = new WeatherService();

    @GetMapping("/")
    public String getWeatherForm(Model model) {
        model.addAttribute("city", "");
        model.addAttribute("weather", null);
        return "index";
    }

    @PostMapping("/")
    public String getWeather(@RequestParam String city, Model model) {
        Weather weather = weatherService.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        return "index";
    }
}