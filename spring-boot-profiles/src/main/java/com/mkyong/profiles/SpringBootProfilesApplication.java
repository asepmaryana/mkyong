package com.mkyong.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mkyong.profiles.service.WeatherService;

@SpringBootApplication
public class SpringBootProfilesApplication implements CommandLineRunner {
	
	@Autowired
    private WeatherService weatherService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(weatherService.forecast());
	}
}
