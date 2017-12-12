package com.sevgi.havadurumu.model;

import org.springframework.stereotype.Component;

@Component
public class Weather
{
    private String cityWeatherMain, cityWeatherDescription, cordinats, temprature, tempratureMin, tempratureMax, pressure, humidity, windSpeed;

    public String getCityWeatherMain()
    {
        return cityWeatherMain;
    }

    public void setCityWeatherMain(String cityWeatherMain)
    {
        this.cityWeatherMain = cityWeatherMain;
    }

    public String getCityWeatherDescription()
    {
        return cityWeatherDescription;
    }

    public void setCityWeatherDescription(String cityWeatherDescription)
    {
        this.cityWeatherDescription = cityWeatherDescription;
    }

    public String getCordinats()
    {
        return cordinats;
    }

    public void setCordinats(String cordinats)
    {
        this.cordinats = cordinats;
    }

    public String getTemprature()
    {
        return temprature;
    }

    public void setTemprature(String temprature)
    {
        this.temprature = temprature;
    }

    public String getTempratureMin()
    {
        return tempratureMin;
    }

    public void setTempratureMin(String tempratureMin)
    {
        this.tempratureMin = tempratureMin;
    }

    public String getTempratureMax()
    {
        return tempratureMax;
    }

    public void setTempratureMax(String tempratureMax)
    {
        this.tempratureMax = tempratureMax;
    }

    public String getPressure()
    {
        return pressure;
    }

    public void setPressure(String pressure)
    {
        this.pressure = pressure;
    }

    public String getHumidity()
    {
        return humidity;
    }

    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }

    public String getWindSpeed()
    {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed)
    {
        this.windSpeed = windSpeed;
    }
}
