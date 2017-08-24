package com.mkyong.profiles.based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProfilesBasedApplication implements CommandLineRunner {
	
	@Autowired
    private ServerProperties serverProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesBasedApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(serverProperties);
	}
}
