package com.sevgi.havadurumu.service;


import com.sevgi.havadurumu.model.Weather;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Component
public class WeatherServiceImpl implements WeatherService
{
    private String APP_ID = "3e496382c36335d91070bd17c7be261d";

    @Autowired
    Weather weather;

    @Override
    public Weather getWeatherDescription(String cityName) throws Exception
    {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=" + APP_ID + "&units=metric&lang=tr&format=json";

        URL obj = new URL(url);

        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }

        in.close();

        Logger.getLogger("Json String :  " + response.toString());

        JSONObject myResponse = new JSONObject(response.toString());

        JSONArray lineItems = myResponse.getJSONArray("weather");

        for (Object o : lineItems)
        {
            JSONObject jsonLineItem = (JSONObject) o;
            weather.setCityWeatherMain(jsonLineItem.getString("main"));
            weather.setCityWeatherDescription(jsonLineItem.getString("description"));
        }

        JSONObject objects = myResponse.getJSONObject("coord");

        weather.setCordinats(String.valueOf(objects.getDouble("lon") + " , " + objects.getDouble("lat")));

        objects = myResponse.getJSONObject("main");

        weather.setTemprature(String.valueOf(objects.getDouble("temp")));
        weather.setPressure(String.valueOf(objects.getDouble("pressure")));
        weather.setTempratureMin(String.valueOf(objects.getDouble("temp_min")));
        weather.setTempratureMax(String.valueOf(objects.getDouble("temp_max")));
        weather.setHumidity(String.valueOf(objects.getDouble("humidity")));

        objects = myResponse.getJSONObject("wind");

        weather.setWindSpeed(String.valueOf(objects.getDouble("speed")));

        return weather;
    }
}
