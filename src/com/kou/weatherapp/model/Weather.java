package com.kou.weatherapp.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

public class Weather {

    @NotNull(message = "Şehir boş bırakılamaz!")
	@Size(min = 1, message = "Şehir adı gerekli")
	private String city;
	
	private String description;
	private String temperature;
	private String humidity;
	private String pressure;
	private String weatherID;
	private String sunriseTime;
	private String sunsetTime;
	private String date;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getWeatherID() {
		return weatherID;
	}
	public void setWeatherID(String weatherID) {
		this.weatherID = weatherID;
	}
	public String getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public String getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
