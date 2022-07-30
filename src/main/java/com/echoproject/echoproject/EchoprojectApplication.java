package com.echoproject.echoproject;
import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.echoproject.echproject.controller.ProductController;

@SpringBootApplication
@ComponentScan("com.echoproject")
@CrossOrigin(origins = "http://localhost:3000")
public class EchoprojectApplication {

	public static void main(String[] args) {
		
		new File(ProductController.uploadDirectory).mkdir();
		SpringApplication.run(EchoprojectApplication.class, args);
	}

}
