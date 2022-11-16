package org.javacream.training.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Starter {
	
	public static void main(String[] args) throws Exception{
		System.out.println("Starting main...");
		SpringApplication.run(Starter.class, args);
	}
}
