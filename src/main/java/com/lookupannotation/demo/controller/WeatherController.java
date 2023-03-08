package com.lookupannotation.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lookupannotation.demo.service.UserService;

@RestController
public class WeatherController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/scope")
	public List<String> getWeatherDetails() {
		String response1= userService.getCurrentDataFromWeatherAPI();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String response2= userService.getCurrentDataFromWeatherAPI();
		return Arrays.asList(response1,response2);
	}
}
