package com.lmd.project.calorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.lmd.project.calorie.repository")
@EntityScan("com.lmd.project.calorie.model")
@ComponentScans(value = { @ComponentScan("com.lmd.project.calorie.controller"),
		@ComponentScan("com.lmd.project.calorie.services") })
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CalorieTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalorieTrackerApplication.class, args);
	}

}
