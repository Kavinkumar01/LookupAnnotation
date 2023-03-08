package com.lookupannotation.demo.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	public WeatherService weatherService;
			
	public String getCurrentDataFromWeatherAPI() {
		return getWeatherServiceBean().getWeatherData();
	}
	
	@Lookup
	public WeatherService getWeatherServiceBean() {
		return null;//what happens internally in return context.getBean(WeatherService.class).getWeatherData();
	}
	
	
	//ObjectProvider solves the problem in the below code
	//but the issue with objectProvider is it eagerInitialized so even when it is not being used it will take space
	/*
	 * @Autowired public WeatherService weatherService;
	 * 
	 * @Autowired ObjectProvider<WeatherService> objectProvider;
	 * 
	 * @Autowired public ApplicationContext context;
	 * 
	 * public String getCurrentDataFromWeatherAPI() { return
	 * objectProvider.getObject().getWeatherData(); }
	 */
	
	//This code fixes the below issue of prototype scope changing to singleton
	//But it is against the principle of Inversion of Control/Dependency Injection
	/*
	 * @Autowired public WeatherService weatherService;
	 * 
	 * @Autowired public ApplicationContext context;
	 * 
	 * public String getCurrentDataFromWeatherAPI() { return
	 * context.getBean(WeatherService.class).getWeatherData(); }
	 */
	

	//-------
	//In the below code when we inject a prototype scope bean(WeatherService) its scope becomes singleton
	/*
	 * @Autowired public WeatherService weatherService;
	 * 
	 * public String getCurrentDataFromWeatherAPI() { return
	 * weatherService.getWeatherData(); }
	 */
}
