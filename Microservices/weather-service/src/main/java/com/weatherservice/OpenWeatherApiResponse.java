package com.weatherservice;

import lombok.Data;

import java.util.List;

@Data
class WeatherInfo {
    private String main;
    private String description;
}

@Data
class Main {
    private Number temp;
    private Number feels_like;
    private Number pressure;
    private Number humidity;
}

@Data
public class OpenWeatherApiResponse {
    private List<WeatherInfo> weather;
    private Main main;
}
