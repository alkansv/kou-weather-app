package com.kou.weatherapp.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kou.weatherapp.model.Weather;
import com.kou.weatherapp.service.WeatherServiceImpl;
import com.sun.el.parser.ParseException;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	private WeatherServiceImpl weatherservice; 
	
	@RequestMapping("/")
	public String showForm(Model model) {

		model.addAttribute("weather", new Weather());
		return "havaform";
	}

	@RequestMapping("/getCity")
	public String pfm(@Valid @ModelAttribute("weather") Weather hava, BindingResult result,Model model){

		System.out.println(hava.getCity());

		if (result.hasErrors()) {
			return "havaform";
		} else {
			weatherservice= new WeatherServiceImpl();
			try {
				hava = weatherservice.getCurrentWeather(hava.getCity());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("weather",hava);

			return "havasonuc";
		}

	}
	
}
