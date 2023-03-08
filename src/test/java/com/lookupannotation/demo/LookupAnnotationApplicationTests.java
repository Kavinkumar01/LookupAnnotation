package com.lookupannotation.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.lookupannotation.demo.service.UserService;
import com.lookupannotation.demo.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LookupAnnotationApplicationTests {

	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void singletonBeanScopeTest() {
		UserService user1=context.getBean(UserService.class);
		UserService user2=context.getBean(UserService.class);
		assertEquals(user1, user2);
	}
	
	@Test
	public void prototypeBeanScopeTest() {
		WeatherService weather1=context.getBean(WeatherService.class);
		WeatherService weather2=context.getBean(WeatherService.class);
		assertNotEquals(weather1, weather2);
	}

}
