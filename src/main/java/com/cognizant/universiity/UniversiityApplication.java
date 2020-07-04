package com.cognizant.universiity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.controller")
public class UniversiityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversiityApplication.class, args);
	}

}
