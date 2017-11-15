package com.kou.weatherapp.service;

import java.io.IOException;

import com.kou.weatherapp.model.Weather;
import com.sun.el.parser.ParseException;

public interface WeatherService {
	Weather getCurrentWeather(String city) throws IOException, ParseException;

}
