package com.sevgi.havadurumu.service;

import com.sevgi.havadurumu.model.Weather;

public interface WeatherService
{
    Weather getWeatherDescription(String cityName) throws Exception;
}
