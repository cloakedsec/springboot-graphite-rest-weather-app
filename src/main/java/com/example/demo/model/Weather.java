package com.example.demo.model;

public class Weather {
    private String city;
    private double temperature;
    private double humidity;
    private String description;

    public Weather() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Weather(String city, double temperature, double humidity, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", description='" + description + '\'' +
                '}';
    }
}
