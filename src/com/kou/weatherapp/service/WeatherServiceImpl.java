package com.kou.weatherapp.service;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.kou.weatherapp.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private static final String API_KEY = "3e496382c36335d91070bd17c7be261d";
	private final JsonWeatherParser parser = new JsonWeatherParser();

	@Override
	public Weather getCurrentWeather(String city) throws IOException{

		System.out.println("API _ KEY : " + API_KEY);
		Weather hava = new Weather();
		hava.setCity(city);
		hava.setTemperature("25");
		hava.setDescription("C");
		
		String result = "";

		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=tr"
				);
		URLConnection urlConnection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			result += result.concat(inputLine);
		}
		in.close();
		System.out.println(result);		

		try {
			hava = parser.getWeather();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hava;
	}

}
