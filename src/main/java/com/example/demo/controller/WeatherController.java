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
        model.addAttribute("city", "");
        model.addAttribute("temperature","");
        model.addAttribute("weatherResponse", null);
        return "index";
    }

    @PostMapping("/search")
    public String getWeather(@RequestParam String city, Model model) throws IOException {
        Weather weatherResponse = weatherService.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("temperature",null);
        model.addAttribute("weatherResponse", weatherResponse);
        return "result";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}




