package com.sevgi.havadurumu.service;

import java.util.ArrayList;

public interface WeatherService
{
    ArrayList<String> getWeatherDescription(String cityName) throws Exception;
}
