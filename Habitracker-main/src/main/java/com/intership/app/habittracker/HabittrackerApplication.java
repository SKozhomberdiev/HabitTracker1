package com.intership.app.habittracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import users.config.AppProperties;

@SpringBootApplication
//@EnableConfigurationProperties(AppProperties.class)
public class HabittrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabittrackerApplication.class, args);
	}

}
