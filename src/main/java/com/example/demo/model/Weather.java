package com.example.demo.model;

import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private double temperature;
    private double humidity;
    private String description;
    private double windSpeed;
    private int visibility;
    private int timezone;


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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public Weather() {

    }

    public Weather(String city, double temperature, double humidity, String description, double windSpeed, int visibility, int timezone) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.timezone = timezone;
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
