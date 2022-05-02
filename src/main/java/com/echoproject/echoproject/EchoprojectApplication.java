package com.echoproject.echoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.echoproject.echproject.controller.ProductController;

@SpringBootApplication
@ComponentScan("com.echoproject")
public class EchoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoprojectApplication.class, args);
	}

}
